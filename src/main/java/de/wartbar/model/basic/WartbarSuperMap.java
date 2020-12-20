package de.wartbar.model.basic;

import de.wartbar.common.WartbarKeyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class WartbarSuperMap<K,V> {

	public Logger logger = LoggerFactory.getLogger(de.wartbar.model.basic.WartbarSuperMap.class);

	private final Object syncObject = new Object();
	private final HashMap<K,V> map = new HashMap<>();
	private final ArrayDeque<K> deque = new ArrayDeque<>();
	private int maxObjectsStored = 0; // 0 means all, never delete

	public WartbarSuperMap() {}

	public void clear() {
		synchronized (syncObject) {
			map.clear();
			deque.clear();
		}
	}

	public int size() {
		synchronized (syncObject) {
			logger.info("size");
			return map.size();
		}
	}

	public void setMaxObjectsStored(int maxObjectsStored) {
		synchronized (syncObject) {
			logger.info("setMaxObjectsStored : " + maxObjectsStored);
			this.maxObjectsStored = maxObjectsStored;
			purgeMap();
		}
	}

	public Object getSyncObject()  {
		return syncObject;
	}

	public HashMap<K, V> cloneMap() {
		synchronized (syncObject) {
			return new HashMap<>(map);
		}
	}

	private void purgeMap() {
		if (maxObjectsStored > 0) {
			while (map.size() > maxObjectsStored) {
				map.remove(deque.pollLast());
				logger.info("purge :" + map.size());
			}
		}
	}

	public void put(K key, V value) {
		synchronized (syncObject) {
			logger.info("put " + key + ":" + value);
			map.put(key, value);
			purgeMap();
			logger.info("put " + "map.size() == " + map.size());
			if (deque.isEmpty()) {
				deque.addFirst(key);
			} else {
				if (!deque.getFirst().equals(key)) {
					deque.addFirst(key);
				}
			}
			logger.info("put " + "deque.size() == " + deque.size());
		}
	}

	/*
	replaces get(K key) because of purgeMap()
	 */
  public V putIfAbsent(K key, V value) {
  	logger.info("putIfAbsent " + key + ":" + value);
		synchronized (syncObject) {
			V receivedValue = map.get(key);
			if (receivedValue == null) {
				put(key, value);
				return value;
			} else {
				if (!deque.getFirst().equals(key)) {
					deque.addFirst(key);
				}
				return receivedValue;
			}
		}
	}

	public void remove(K key) {
		logger.info("remove " + key);
		synchronized (syncObject) {
			map.remove(key);

			ArrayDeque<K> localDeque = new ArrayDeque<>(deque);
			deque.clear();
			Iterator<K> iter = localDeque.iterator();

			while (iter.hasNext()) {
				if (key != iter.next()) {
					deque.add(key);
				}
			}
		}
	}

	public ArrayDeque<WartbarKeyValue<K,V>> getUpdateOrder() {
		synchronized (syncObject) {

			logger.info("getUpdateOrder " + "deque.size() == " + deque.size());

			Iterator<K> iterDeque = deque.iterator();
			while (iterDeque.hasNext()) {
				logger.info(iterDeque.next().toString());
			}

			logger.info("getUpdateOrder " + "map.size() == " + map.size());

			logger.info(map.keySet().toString());


			ArrayDeque<WartbarKeyValue<K,V>> localDeque = new ArrayDeque<>();
			HashSet<K> keys = new HashSet<>();
			Iterator<K> iter = deque.iterator();

			while (keys.size() < deque.size()) {
				if (iter.hasNext()) {
					K key = iter.next();

					if (keys.contains(key)) {
						continue;
					}

					V value = map.get(key);
					WartbarKeyValue<K,V> keyValue = new WartbarKeyValue<>(key, value);
					localDeque.add(keyValue);
					keys.add(key);
					logger.info("getUpdateOrder added " + key);
				} else {
					break;
				}
			}

			return localDeque;
		}
	}

}

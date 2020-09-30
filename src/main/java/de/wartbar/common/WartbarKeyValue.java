package de.wartbar.common;

public class WartbarKeyValue<K,V> {
	private K key;
	private V value;

	public WartbarKeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() { return this.key; }
	public V getValue() { return this.value; }
}
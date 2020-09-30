package de.wartbar.model.basic;

import de.wartbar.common.WartbarKeyValue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;


public class WartbarSuperMapTest {

	@BeforeAll
	static void setup(){
		System.out.println("@BeforeAll executed");
	}

	@BeforeEach
	void setupThis(){
		System.out.println("@BeforeEach executed");
	}

	@Tag("DEV")
	@Test
	void testGetUpdateOrder()
	{
		WartbarSuperMap<String, String> map = new WartbarSuperMap<>();
		map.put("A","1");
		map.put("B","2");
		map.put("C","3");

		ArrayDeque<WartbarKeyValue<String, String>> deque = map.getUpdateOrder();
		Iterator<WartbarKeyValue<String, String>> iter = deque.iterator();

		assert iter.hasNext();
		assert iter.next().getValue().equals("3");
		assert iter.hasNext();
		assert iter.next().getValue().equals("2");
		assert iter.hasNext();
		assert iter.next().getValue().equals("1");
	}

	@Tag("DEV")
	@Test
	void testCloneMap()
	{
		WartbarSuperMap<String, String> map = new WartbarSuperMap<>();
		map.put("A","1");
		map.put("B","2");
		map.put("C","3");

		HashMap<String,String> clonedMap = map.cloneMap();
		assert clonedMap.size() == 3;
		assert clonedMap.containsKey("A");
		assert clonedMap.containsKey("B");
		assert clonedMap.containsKey("C");
	}

	@Tag("DEV")
	@Test
	void testPutIfAbsent()
	{
		WartbarSuperMap<String, String> map = new WartbarSuperMap<>();
		map.putIfAbsent("A","1");
		map.putIfAbsent("B","2");
		map.putIfAbsent("C","3");
		map.putIfAbsent("C","7");
		map.putIfAbsent("B","23");

		HashMap<String,String> clonedMap = map.cloneMap();
		assert clonedMap.size() == 3;
		assert clonedMap.containsKey("A");
		assert clonedMap.containsKey("B");
		assert clonedMap.containsKey("C");
		assert clonedMap.get("B").equals("2");
		assert clonedMap.get("C").equals("3");
	}

	@Tag("DEV")
	@Test
	void testPut()
	{
		WartbarSuperMap<String, String> map = new WartbarSuperMap<>();
		map.put("A","1");
		map.put("B","2");
		map.put("C","3");
		map.put("C","7");
		map.put("B","23");

		HashMap<String,String> clonedMap = map.cloneMap();
		assert clonedMap.size() == 3;
		assert clonedMap.containsKey("A");
		assert clonedMap.containsKey("B");
		assert clonedMap.containsKey("C");
		assert clonedMap.get("B").equals("23");
		assert clonedMap.get("C").equals("7");
	}

	@Tag("DEV")
	@Test
	void testSetMaxObjectsStored()
	{
		WartbarSuperMap<String, String> map = new WartbarSuperMap<>();
		map.setMaxObjectsStored(2);
		map.put("A","1");
		map.put("B","2");
		map.put("C","3");
		map.put("C","4");
		map.put("C","5");
		map.put("D","3");


		HashMap<String,String> clonedMap = map.cloneMap();

		System.out.println("clonedMap : " + clonedMap.size());
		assert clonedMap.size() == 2;
		assert clonedMap.containsKey("C");
		assert clonedMap.containsKey("D");

		map.setMaxObjectsStored(1);
		clonedMap = map.cloneMap();
		assert clonedMap.size() == 1;
		assert clonedMap.containsKey("D");

		map.setMaxObjectsStored(0);
		map.put("A","1");
		map.put("B","2");
		clonedMap = map.cloneMap();
		assert clonedMap.size() == 3;
		assert clonedMap.containsKey("A");
		assert clonedMap.containsKey("B");
		assert clonedMap.containsKey("D");
		assert clonedMap.get("A").equals("1");
		assert clonedMap.get("B").equals("2");
		assert clonedMap.get("D").equals("3");

	}

	@AfterEach
	void tearThis(){
		System.out.println("@AfterEach executed");
	}

	@AfterAll
	static void tear(){
		System.out.println("@AfterAll executed");
	}
}
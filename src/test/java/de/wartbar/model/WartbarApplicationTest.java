package de.wartbar.model;


import de.wartbar.model.basic.WartbarSection;
import de.wartbar.model.basic.WartbarSubSection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;

public class WartbarApplicationTest {


	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll executed");
	}

	@BeforeEach
	void setupThis() {
		System.out.println("@BeforeEach executed");
	}

	@Tag("DEV")
	@Test
	void testGetUpdateOrder() {
		System.out.println("testGetUpdateOrder");
		WartbarApplication.clear();
		WartbarSection section = WartbarApplication.putIfAbsent("section1testGetUpdateOrder",1);
		assert section.getName().equals("section1testGetUpdateOrder");

		section.putProperty("subsection1", "key1", "value1");
		section.putProperty("subsection1", "key2", "value2");
		section.putProperty("subsection1", "key3", "value3");

		ArrayDeque<WartbarSection> deque = WartbarApplication.getUpdateOrder(1);
		assert deque.size() != 0;
		assert deque.size() == 1;
		assert deque.getFirst().cloneSubSectionMap().get("subsection1").cloneMap().size() == 3;

		section = WartbarApplication.putIfAbsent("section1testGetUpdateOrder",1);

		section.putProperty("subsection2", "key4", "value4");
		section.putProperty("subsection2", "key5", "value5");
		section.putProperty("subsection1", "key6", "value6");
		deque = WartbarApplication.getUpdateOrder(1);
		assert deque.size() == 1;

		HashMap<String, WartbarSubSection> wartbarSubSectionMap = deque.getFirst().cloneSubSectionMap();
		assert wartbarSubSectionMap.size() == 2;
		assert wartbarSubSectionMap.get("subsection1").cloneMap().size() == 4;
		assert wartbarSubSectionMap.get("subsection2").cloneMap().size() == 2;
	}

	@Tag("DEV")
	@Test
	void testPutProperty() {
		System.out.println("testPutProperty");
		WartbarApplication.clear();
		WartbarSection section = WartbarApplication.putIfAbsent("section1testPutProperty",1);
		section.putProperty("subsection1", "key1", "value1");
		section.putProperty("subsection1", "key2", "value2");
		section.putProperty("subsection2", "key3", "value3");
		assert section.getName().equals("section1testPutProperty");

		HashMap<String, WartbarSection> sectionMap = WartbarApplication.cloneSectionMap();

		assert sectionMap.size() == 1;

		WartbarSection sectionReceived = sectionMap.get("section1testPutProperty");
		HashMap<String, WartbarSubSection> subSectionMap = sectionReceived.cloneSubSectionMap();

    assert subSectionMap.size() == 2;
		assert subSectionMap.containsKey("subsection1");
		assert subSectionMap.containsKey("subsection2");
		assert subSectionMap.get("subsection1").cloneMap().size() == 2;
		assert subSectionMap.get("subsection2").cloneMap().size() == 1;
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

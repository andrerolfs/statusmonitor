package de.wartbar.model.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class WartbarSectionTest {

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
	void testPutProperty() {
		WartbarSection section = new WartbarSection("section1", 1);
		section.putProperty("subsection1", "A", "1");
		section.putProperty("subsection1", "B", "2");
		section.putProperty("subsection1", "C", "3");

		HashMap<String, WartbarSubSection> subSectionMap = section.cloneSubSectionMap();

		assert subSectionMap.size() == 1;
		assert subSectionMap.containsKey("subsection1");

		WartbarSubSection subSection = subSectionMap.get("subsection1");

		HashMap<String, String> map = subSection.cloneMap();

		assert map.size() == 3;
		assert map.containsKey("A");
		assert map.containsKey("B");
		assert map.containsKey("C");
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
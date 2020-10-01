package de.wartbar.common;

import de.wartbar.model.WartbarApplication;
import de.wartbar.model.basic.WartbarSection;

public class DemoValues {

	public static void addDemoValues() {

		WartbarApplication.setLevel(1, "Level 1", 1);
		WartbarApplication.setLevel(2, "Level 2", 2);
		WartbarApplication.setLevel(3, "Level 3", 3);
		WartbarApplication.setLevel(4, "Level 4", 4);
		WartbarApplication.setLevel(5, "Level 5", 5);
		WartbarApplication.setLevel(6, "Level 6", 6);
		WartbarApplication.setLevel(7, "Level 7", 7);
		WartbarApplication.setLevel(9, "System Test Status", 7);

		WartbarSection section = WartbarApplication.putIfAbsent("Info Tool A", 1);
		section.putProperty("BackgroundColor", "1", "red FF0000");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.putProperty("Values", "w", "some string");
		section.setTileBackground(1);

		section = WartbarApplication.putIfAbsent("Uptime Tool B", 1);
		section.putProperty("BackgroundColor", "2", "dark green 004400");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.setTileBackground(2);

		section = WartbarApplication.putIfAbsent("Uptime Tool C", 1);
		section.putProperty("BackgroundColor", "3", "blue 0000FF");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.setTileBackground(3);

		section = WartbarApplication.putIfAbsent("Uptime Tool D", 1);
		section.putProperty("BackgroundColor", "4", "dark green 006400");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.putProperty("Values", "w", "some string");
		section.setTileBackground(4);

		section = WartbarApplication.putIfAbsent("Uptime Tool E", 1);
		section.putProperty("BackgroundColor", "5", "dark orange EE7C00");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.setTileBackground(5);

		section = WartbarApplication.putIfAbsent("Info Tool F", 2);
		section.putProperty("BackgroundColor", "6", "dim grey 696969");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.putProperty("Values", "w", "some string");
		section.setTileBackground(6);

		section = WartbarApplication.putIfAbsent("Uptime Tool G", 2);
		section.putProperty("BackgroundColor", "7", "fire brick B22222");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.setTileBackground(7);

		section = WartbarApplication.putIfAbsent("Uptime Tool H", 3);
		section.putProperty("BackgroundColor", "8", "forest green 228B22");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.setTileBackground(8);

		section = WartbarApplication.putIfAbsent("Uptime Tool I", 4);
		section.putProperty("BackgroundColor", "9", "cyan 2F6F6F");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.putProperty("Values", "w", "some string");
		section.setTileBackground(9);

		section = WartbarApplication.putIfAbsent("Uptime Tool J", 4);
		section.putProperty("BackgroundColor", "10", "indigo 4B0082");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.setTileBackground(10);

		section = WartbarApplication.putIfAbsent("Info Tool K", 5);
		section.putProperty("BackgroundColor", "11", "midnight blue 191970");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.putProperty("Values", "w", "some string");
		section.setTileBackground(11);

		section = WartbarApplication.putIfAbsent("Uptime Tool L", 6);
		section.putProperty("BackgroundColor", "12", "orange red FF4500");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.setTileBackground(12);

		section = WartbarApplication.putIfAbsent("Uptime Tool M", 7);
		section.putProperty("BackgroundColor", "13", "deep pink FF1493");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.setTileBackground(13);

		section = WartbarApplication.putIfAbsent("Uptime Tool N", 7);
		section.putProperty("BackgroundColor", "14", "slate grey 708090");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.putProperty("Values", "w", "some string");
		section.setTileBackground(14);

		section = WartbarApplication.putIfAbsent("Uptime Tool O", 7);
		section.putProperty("BackgroundColor", "15", "teal 008080");
		section.putProperty("Current", "Started", "20200914");
		section.putProperty("Current", "Uptime", "19H17M15S");
		section.putProperty("Last", "Started", "20200823");
		section.putProperty("Last", "Uptime", "08D15H13M17S");
		section.putProperty("Values", "i", "555");
		section.putProperty("Values", "j", "3");
		section.putProperty("Values", "k", "-1");
		section.setTileBackground(15);


		// nice showcase

		// 7 fire brick
		// 4 dark green
		// 3 blue
		// 5 dark orange

		section = WartbarApplication.putIfAbsent("Test Run 21", 9);
		section.putProperty("Run Status", "2", "Ongoing");
		section.putProperty("Test Status", "Finished", "29");
		section.putProperty("Test Status", "ToDo", "12");
		section.putProperty("Test Status", "Failed", "4");
		section.setTileBackground(5);

		section = WartbarApplication.putIfAbsent("Test Run 16", 9);
		section.putProperty("Run Status", "1", "Finished");
		section.putProperty("Test Status", "Finished", "63");
		section.putProperty("Test Status", "ToDo", "0");
		section.putProperty("Test Status", "Failed", "0");
		section.setTileBackground(4);

		section = WartbarApplication.putIfAbsent("Test Run 7", 9);
		section.putProperty("Run Status", "1", "Finished");
		section.putProperty("Test Status", "Finished", "32");
		section.putProperty("Test Status", "ToDo", "0");
		section.putProperty("Test Status", "Failed", "4");
		section.setTileBackground(5);

		section = WartbarApplication.putIfAbsent("Test Run 18", 9);
		section.putProperty("Run Status", "1", "Finished");
		section.putProperty("Test Status", "Finished", "63");
		section.putProperty("Test Status", "ToDo", "0");
		section.putProperty("Test Status", "Failed", "0");
		section.setTileBackground(4);


		section = WartbarApplication.putIfAbsent("Test Run 22", 9);
		section.putProperty("Run Status", "2", "Ongoing");
		section.putProperty("Test Status", "Finished", "28");
		section.putProperty("Test Status", "ToDo", "15");
		section.putProperty("Test Status", "Failed", "0");
		section.setTileBackground(3);

		section = WartbarApplication.putIfAbsent("Test Run 17", 9);
		section.putProperty("Run Status", "1", "Finished");
		section.putProperty("Test Status", "Finished", "42");
		section.putProperty("Test Status", "ToDo", "0");
		section.putProperty("Test Status", "Failed", "0");
		section.setTileBackground(4);

		section = WartbarApplication.putIfAbsent("Test Run 19", 9);
		section.putProperty("Run Status", "3", "On Hold");
		section.putProperty("Problem Status", "333", "Major Incident - Needs Help");
		section.putProperty("Test Status", "Finished", "37");
		section.putProperty("Test Status", "ToDo", "15");
		section.putProperty("Test Status", "Failed", "8");
		section.setTileBackground(7);

	}
}

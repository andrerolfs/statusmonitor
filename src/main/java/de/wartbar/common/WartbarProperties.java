package de.wartbar.common;

import de.wartbar.html.CSS;
import de.wartbar.main.Sync;

import java.sql.Timestamp;
import java.util.*;

public class WartbarProperties {

	private HashMap<String, String> propertyMap = new HashMap<>();
	private HashMap<String, Timestamp> prefixMap = new HashMap<>();
	private List<String> propertyOrderList = new ArrayList<>();
	private Set<String> propertySet = new HashSet<>();

	public WartbarProperties() {
		setProperty("wartbar", "statusmonitor_x", "3");
		setProperty("wartbar", "background", "1");
		setProperty("wartbar", "demo", "false");
	}

	public void updateDemoData() {
		if (demoMode()) {
			setProperty("Info Tool A", "i", "555");
			setProperty("Info Tool A", "j", "3");
			setProperty("Info Tool A", "k", "-1");
			setProperty("Info Tool A", "w", "some string");
			setProperty("Info Tool A", "selectPrefix", "<a href=\"http://localhost:8080/selectPrefix\">selectPrefix</a>");



			setProperty("Unit Test Info Tool B", "Executed", "77");
			setProperty("Unit Test Info Tool B", "Passed", "67");
			setProperty("Unit Test Info Tool B", "Failed", "10");

			setProperty("Uptime Tool C", "Started", "20200601");
			setProperty("Uptime Tool C", "Uptime", "23H47M");

			setProperty("User Status Tool D", "Logged In Now", "3");
			setProperty("User Status Tool D", "Users Today", "22");
			setProperty("User Status Tool D", "Function A Used Today", "4");
			setProperty("User Status Tool D", "Function B Used Today", "20");
			setProperty("User Status Tool D", "Function C Used Last Month", "433");

			setProperty("Jenkins Status", "Current Runs", "7");
			setProperty("Jenkins Status", "Clients Up", "15");
			setProperty("Jenkins Status", "Clients Down", "2");

			setProperty("Requests Status", "Today", "333");
			setProperty("Requests Status", "Yesterday", "278");
			setProperty("Requests Status", "Last Week", "1025");
			setProperty("Requests Status", "Last Month", "4230");

			setProperty("Current Date Time", "Year", "2020");
			setProperty("Current Date Time", "Month", "6");
			setProperty("Current Date Time", "Day", "1");
			setProperty("Current Date Time", "Hour", "6");
			setProperty("Current Date Time", "Minute", "47");
		}
	}

	public List<String> getPropertyOrderList() {
		return propertyOrderList;
	}

	public void setPropertyOrderList(List<String> list) {
		propertyOrderList = list;
	}


	public Integer getStatusMonitorDimension() {
		HashMap<String, String> localMap = getProperties("wartbar");
		return Integer.parseInt(localMap.get("statusmonitor_x"));
	}

	public boolean demoMode() {
		HashMap<String, String> localMap = getProperties("wartbar");
		if (localMap.get("demo").toUpperCase().equals("TRUE")) {
			return true;
		} else {
			return false;
		}
	}

	public int getBackgroundId() {
		HashMap<String, String> localMap = getProperties("wartbar");
		return Integer.parseInt(localMap.get("background"));
	}

	public void setProperty(String prefix, String key, String value) {
		propertyMap.put(prefix + "_" + key, value);
		if (propertySet.add(key)) {
			propertyOrderList.add(key);
		}
		prefixMap.put(prefix, new Timestamp(System.currentTimeMillis()));
	}

	public List<String> getPrefixOrder() {
		List<String> prefixInOrder = new ArrayList<>(prefixMap.keySet());
		return prefixInOrder;
	}

	public HashMap<String, String> getProperties(String prefix) {
		HashMap<String, String> localMap = new HashMap<>();

		for (String key : propertyMap.keySet()) {
			if (key.startsWith(prefix + "_")) {
				localMap.put(key.replace(prefix + "_", ""), propertyMap.get(key));
			}
		}

		return localMap;
	}

}

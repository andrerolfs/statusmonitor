package de.wartbar.model.basic;

import de.wartbar.common.WartbarBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class WartbarSection extends WartbarBase {

	public Logger logger = LoggerFactory.getLogger(de.wartbar.model.basic.WartbarSection.class);

	private final String name;
	private final Object syncObject = new Object();
	private int level;
	private long version = 0;
	private int background = 1;

	// subsection name => subsection
	// in alphabetical order
	private final WartbarSuperMap<String,WartbarSubSection> subSectionMap = new WartbarSuperMap<>();

	// link name => url
	private final WartbarSuperMap<String,String> urlMap = new WartbarSuperMap<>();

	public WartbarSection(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	// level

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// tile

	public void setTileBackground(int background) {
		synchronized (syncObject) {
			this.background = background;
		}
	}

	public int getTileBackground() {
		return background;
	}

	// properties

	public long getVersion() {
		return version;
	}

	public void putProperty(String subsectionName, String key, String value) {
		synchronized (syncObject) {
			logger.info("putProperty " + subsectionName + ":" + key + ":" + value);
			WartbarSubSection subSection = subSectionMap.putIfAbsent(subsectionName, new WartbarSubSection());
			subSection.put(key, value);
			version++;
		}
	}

	// provide clone functions to get data for rendering views

	public HashMap<String, WartbarSubSection> cloneSubSectionMap() {
		return subSectionMap.cloneMap();
	}

	public HashMap<String, String> cloneSubSection(String subsectionName) {
		synchronized (syncObject) {
			logger.info("cloneSubSection " + subsectionName);
			WartbarSubSection subSection = subSectionMap.putIfAbsent(subsectionName, new WartbarSubSection());
			return subSection.cloneMap();
		}
	}

	public void removeSubSection(String subsectionName) {
		synchronized (syncObject) {
			logger.info("removeSubSection " + subsectionName);
			subSectionMap.remove(subsectionName);
		}
	}

	public int size() {
		synchronized (syncObject) {
			logger.info("size");
			return subSectionMap.size();
		}
	}


	public HashMap<String, String> cloneUrlMap() {
		return urlMap.cloneMap();
	}

}

package de.wartbar.model;

import de.wartbar.common.WartbarKeyValue;
import de.wartbar.model.basic.WartbarLevel;
import de.wartbar.model.basic.WartbarSection;
import de.wartbar.model.basic.WartbarSuperMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;

public class WartbarApplication {

	public static Logger logger = LoggerFactory.getLogger(de.wartbar.model.WartbarApplication.class);

	// section name -> section properties
	private static final WartbarSuperMap<String, WartbarSection> sections = new WartbarSuperMap<>();

	private static final WartbarSuperMap<Integer, WartbarLevel> levelMap = new WartbarSuperMap();

	public static void setLevel(Integer level, String levelName, int levelBackground) {
		WartbarLevel wartbarLevel = new WartbarLevel(levelName, levelBackground);
		levelMap.put(level, wartbarLevel);
	}

	public static WartbarLevel getLevel(Integer level) {
		return levelMap.putIfAbsent(level, new WartbarLevel(level.toString(),1));
	}

	public static WartbarSection putIfAbsent(String sectionName, int level) {
		logger.info("putIfAbsent " + sectionName + ":" + level);
		WartbarSection section = sections.putIfAbsent(sectionName, new WartbarSection(sectionName, level));
		assert section != null;
		section.setLevel(level);
		return section;
	}

	public static HashMap<String, WartbarSection> cloneSectionMap() {
		return sections.cloneMap();
	}

	private static int background = 7;
	private static int tilesPerRow = 4;

	public static int getBackground() {
		return background;
	}

	public static void setBackground(int background) {
		WartbarApplication.background = background;
	}

	public static int getTilesPerRow() {
		return tilesPerRow;
	}

	public static void setTilesPerRow(int tilesPerRow) {
		WartbarApplication.tilesPerRow = tilesPerRow;
	}

	public static void setMaxApplications(int maxApplications) {
		sections.setMaxObjectsStored(maxApplications);
	}

	public static ArrayDeque<WartbarSection> getUpdateOrder(int level) {
		ArrayDeque<WartbarKeyValue<String,WartbarSection>> allLevels = sections.getUpdateOrder();

		logger.info("getUpdateOrder all levels : " + allLevels.size());
		ArrayDeque<WartbarSection> selectedLevel = new ArrayDeque<>();

		Iterator<WartbarKeyValue<String,WartbarSection>> iter = allLevels.iterator();

		while(iter.hasNext()) {
			WartbarKeyValue<String,WartbarSection> keyValuePair = iter.next();

			if (keyValuePair.getValue().getLevel() == level) {
				selectedLevel.add(keyValuePair.getValue());
			}
		}

		logger.info("getUpdateOrder selected level sections : " + selectedLevel.size());
		return selectedLevel;
	}

	public static void clear() {
		levelMap.clear();
		sections.clear();
	}

	public static HashMap<String, String> cloneSubSection(String sectionName, String subSectionName) {
		WartbarSection section = sections.putIfAbsent(sectionName, null);

		if (section == null) {
			return null;
		}

		return section.cloneSubSection(subSectionName);
	}

	public static void removeSubSection(String sectionName, String subSectionName) {
		WartbarSection section = sections.putIfAbsent(sectionName, null);

		if (section == null) {
			return;
		}

		section.removeSubSection(subSectionName);
	}
}

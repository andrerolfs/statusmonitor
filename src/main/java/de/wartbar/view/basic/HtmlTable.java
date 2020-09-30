package de.wartbar.view.basic;

import de.wartbar.common.WartbarBase;
import de.wartbar.model.basic.WartbarSection;
import de.wartbar.model.basic.WartbarSubSection;

import java.util.HashMap;
import java.util.Iterator;

public class HtmlTable extends WartbarBase {

	public static String getTileTable(WartbarSection section) {

		HashMap<String, WartbarSubSection> subSectionMap = section.cloneSubSectionMap();

		HTMLTableBuilder builder = new HTMLTableBuilder();
		builder.
						tableBegin(section.getName(), section.getTileBackground()).
						tableMainHeaderRows(section.getName());

		Iterator<String> subSectionIter = subSectionMap.keySet().stream().sorted().iterator();

		while (subSectionIter.hasNext()) {
			String subSectionName = subSectionIter.next();
			WartbarSubSection subsection = subSectionMap.get(subSectionName);

			builder.tableSubHeaderRows(subSectionName);

			HashMap<String, String> propertyMap = subsection.cloneMap();

			Iterator<String> propertyIter = propertyMap.keySet().stream().sorted().iterator();

			while (propertyIter.hasNext()) {
				String propertyName = propertyIter.next();
				builder.tableRow(propertyName, propertyMap.get(propertyName));
			}
		}

		return builder.tableEnd().toString();
	}

}

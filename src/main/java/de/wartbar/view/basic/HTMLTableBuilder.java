package de.wartbar.view.basic;

import de.wartbar.common.HTMLToolBox;
import de.wartbar.common.WartbarPair;
import de.wartbar.common.WartbarBase;

import java.util.List;

public class HTMLTableBuilder extends WartbarBase {

	private String output = "";

	public String toString() {
		return output;
	}


	public HTMLTableBuilder tableBegin(String id, int tableClass) {
		output += "<table id=\"" + HTMLToolBox.whitespaceToUnderscore(id) + "\" " +
						"class=\"tableclass" + CSS.getValidTableClass(tableClass) + "\"" +
						">" + nl;
		return this;
	}

	public HTMLTableBuilder tableEnd() {
		output += "</table>" + nl;
		return this;
	}

	public HTMLTableBuilder tableMainHeaderRows(String headline) {
		output +=
						"  <tr>" + nl +
										"    <th class=\"mainheader\" colspan=\"3\">&nbsp;&nbsp;" + headline + "&nbsp;&nbsp;</th>" + nl +
										"  </tr>" + nl;
		return this;
	}

	public HTMLTableBuilder tableSubHeaderRows(String headline) {
		output +=
						"  <tr>" + nl +
										"    <th class=\"subheader\" colspan=\"3\">" + headline + "</th>" + nl +
										"  </tr>" + nl;
		return this;
	}

	public HTMLTableBuilder tableRow(String key, String value) {
		output += "<tr>" + nl +
							"<td>" + key + "</td>" + nl +
							"<td>&nbsp;</td>" + nl +
							"<td>" + value + "</td>" + nl +
							"</tr>" + nl;

		return this;
	}
}

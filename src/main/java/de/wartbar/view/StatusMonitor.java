package de.wartbar.view;

import de.wartbar.model.WartbarApplication;
import de.wartbar.model.basic.WartbarSection;
import de.wartbar.view.basic.CSS;
import de.wartbar.view.basic.HTML;
import de.wartbar.view.basic.HtmlTable;

import java.util.ArrayDeque;

/*
Show all sections for a level
 */
public class StatusMonitor extends HTML {

	public static String getStatusMonitor(ArrayDeque<WartbarSection> tiles, int level) {

		StringBuilder contentBuilder = new StringBuilder();

		contentBuilder
						.append("<!DOCTYPE html>").append(nl)
						.append(HTML.htmlBegin()).append(nl)
						.append(HTML.headBegin()).append(nl)
						.append(HTML.styleBegin()).append(nl)
						.append("body {").append(nl)
						.append("background: #000000;").append(nl)
						.append("color: white;").append(nl)
						.append("}").append(nl)
						.append("table {").append(nl)
						.append("border-radius: 10px;").append(nl)
						.append("color: white;").append(nl)
						.append("padding: 40px;").append(nl)
						.append("vertical-align:top;").append(nl)
						.append("}").append(nl)
						.append("th.mainheader {").append(nl)
						.append("font-size: 22px;").append(nl)
						.append("background: #ffffff;").append(nl)
						.append("vertical-align:top;").append(nl)
						.append("color: black;").append(nl)
						.append("}").append(nl)
						.append("th.subheader {").append(nl)
						.append("font-size: 18px;").append(nl)
						.append("background: #ffffff;").append(nl)
						.append("vertical-align:top;").append(nl)
						.append("color: black;").append(nl)
						.append("}").append(nl)
						.append("td {").append(nl)
						.append("font-size: 16px;").append(nl)
						.append("vertical-align:top;").append(nl)
						.append("color: white;").append(nl)
						.append("}").append(nl);

		for (int i = 0; i <= 16; i++) {
			contentBuilder.append(CSS.getTableClass(i)).append(nl);
		}

		contentBuilder.append("#outer {").append(nl)
						.append("width: 100%;").append(nl)
						.append(CSS.getOuterBackground(WartbarApplication.getLevel(level).getBackground())).append(nl)
						.append("}").append(nl)
						.append(HTML.styleEnd()).append(nl)
						.append(HTML.title("StatusMonitor")).append(nl)
						.append(HTML.headEnd()).append(nl)
						.append(HTML.bodyBegin())
						.append(HTML.H1(WartbarApplication.getLevel(level).getName()))
						.append(HTML.br()).append(nl)
						.append(HTML.a("Link List", "http://localhost:8080/links")).append(nl)
						.append(HTML.br()).append(nl)
						.append(HTML.br()).append(nl)
						.append(HTML.tableBegin("outer")).append(nl)
						.append(HTML.trBegin()).append(nl);

		int tilesPerRow = WartbarApplication.getTilesPerRow();
		int rowSize = 0;

		for (WartbarSection tile : tiles) {
			contentBuilder.append(HTML.tdBegin("td" + tile.getName()));
			contentBuilder.append(HtmlTable.getTileTable(tile));
			contentBuilder.append(HTML.tdEnd());
			rowSize++;
			if(rowSize == tilesPerRow) {
				contentBuilder.append(HTML.trEnd()).append(nl);
				contentBuilder.append(HTML.trBegin()).append(nl);
				rowSize = 0;
			}
		}

		contentBuilder
						.append(HTML.trEnd()).append(nl)
						.append(HTML.tableEnd()).append(nl)
						.append(HTML.bodyEnd()).append(nl)
						.append(HTML.htmlEnd()).append(nl);

		return contentBuilder.toString();
	}

}

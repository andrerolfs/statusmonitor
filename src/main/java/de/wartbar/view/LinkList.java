package de.wartbar.view;

import de.wartbar.view.basic.HTML;

public class LinkList {


	public static String getLinkList() {

		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(HTML.docType())
						.append(HTML.htmlBegin())
						.append(HTML.headBegin())
						.append(HTML.metaContentTypeApplicationJson())
						.append(HTML.title("List of links"))
						.append(HTML.headEnd())
						.append(HTML.bodyBegin())
						.append(HTML.H1("List of links"))
						.append(HTML.br())
						.append(HTML.a("add Demo values", "http://localhost:8080/demovalues"))
						.append(HTML.br())
						.append(HTML.a("Level Editor", "http://localhost:8080/leveleditor"))
						.append(HTML.br())
						.append(HTML.a("Property Editor", "http://localhost:8080/propertyeditor"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 1", "http://localhost:8080/statusmonitor?Level=1"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 2", "http://localhost:8080/statusmonitor?Level=2"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 3", "http://localhost:8080/statusmonitor?Level=3"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 4", "http://localhost:8080/statusmonitor?Level=4"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 5", "http://localhost:8080/statusmonitor?Level=5"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 6", "http://localhost:8080/statusmonitor?Level=6"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 7", "http://localhost:8080/statusmonitor?Level=7"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 8", "http://localhost:8080/statusmonitor?Level=8"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor Level 9", "http://localhost:8080/statusmonitor?Level=9"))
						.append(HTML.br())
						.append(HTML.br());

		return contentBuilder.toString();
	}
}
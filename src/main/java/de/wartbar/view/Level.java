package de.wartbar.view;

import de.wartbar.view.basic.HTML;

/*
Define which level has which name : int => String
 */
public class Level {


	public static String getLevelEditor() {

		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(HTML.docType())
						.append(HTML.htmlBegin())
						.append(HTML.headBegin())
						.append(HTML.metaContentTypeApplicationJson())
						.append(HTML.title("Edit a Level"))
						.append(HTML.headEnd())
						.append(HTML.bodyBegin())
						.append(HTML.H1("Edit a Level"))
						.append(HTML.br())
						.append(HTML.a("Link List", "http://localhost:8080/links"))
						.append(HTML.br())
						.append(HTML.br())
						.append(HTML.formBegin("http://localhost:8080/leveleditor", "post"))
						.append(HTML.tableBegin(""));

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("Level", "Level"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","Level","Level", ""))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("Name", "Name"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","Name","Name", ""))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("Background", "Background"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","Background","Background", ""))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		contentBuilder
						.append(HTML.tableEnd())
						.append(HTML.input(
										"submit",
										"submit-property",
										"submit",
										"Submit"))
						.append(HTML.formEnd())
						.append(HTML.htmlEnd());

		return contentBuilder.toString();

	}

}

package de.wartbar.view;

import de.wartbar.common.HTMLToolBox;
import de.wartbar.view.basic.HTML;

import java.util.HashMap;

/*
Define a property with :

* Level
* Application
* Section
* Subsection
* Key Value

 */
public class Property {


	public static String getPropertyEditor() {

		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(HTML.docType())
						.append(HTML.htmlBegin())
						.append(HTML.headBegin())
						.append(HTML.metaContentTypeApplicationJson())
						.append(HTML.title("Edit a Property"))
						.append(HTML.headEnd())
						.append(HTML.bodyBegin())
						.append(HTML.H1("Edit a Property"))
						.append(HTML.br())
						.append(HTML.a("Link List", "http://localhost:8080/links"))
						.append(HTML.br())
						.append(HTML.br())
						.append(HTML.formBegin("http://localhost:8080/propertyeditor", "post"))
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
						.append(HTML.label("Section", "Section"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","Section","Section", ""))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("SubSection", "SubSection"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","SubSection","SubSection", ""))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("Key", "Key"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","Key","Key", ""))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("Value", "Value"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","Value","Value", ""))
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

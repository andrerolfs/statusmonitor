package de.wartbar.html;

import de.wartbar.common.WartbarBase;

import java.util.HashMap;

public class PrefixEditor extends WartbarBase {

	public static boolean isWartbar(String prefix) {
		return prefix.toUpperCase().equals("WARTBAR");
	}

	public static String getEditPrefix(String prefix) {

		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(HTML.docType())
						.append(HTML.htmlBegin())
						.append(HTML.headBegin())
						.append(HTML.metaContentTypeApplicationJson())
						.append(HTML.title("Edit Prefix " + prefix))
						.append(HTML.headEnd())
						.append(HTML.bodyBegin())
						.append(HTML.H1("Edit properties of prefix "))
						.append(HTML.br())
						.append(HTML.a("Link List", "http://localhost:8080/links"))
						.append(HTML.br())
						.append(HTML.br())
						.append(HTML.formBegin("http://localhost:8080/editPrefix", "post"))
						.append(HTML.tableBegin(""));

		if (isWartbar(prefix)) {
			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append("This is the configuration of the StatusMonitor Service!")
							.append(HTML.tdEnd())
							.append(HTML.trEnd());

			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append(HTML.hr())
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append(HTML.hr())
							.append(HTML.tdEnd())
							.append(HTML.trEnd());

			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append("statusmonitor_x")
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append("A number for how many tiles shall be presented in a row.")
							.append(HTML.tdEnd())
							.append(HTML.trEnd());

			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append("background")
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append("A number of 1 - 3 to select a background pattern")
							.append(HTML.tdEnd())
							.append(HTML.trEnd());

			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append("demo")
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append("If set true a set of demo tiles is added to play with.")
							.append(HTML.tdEnd())
							.append(HTML.trEnd());

			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append(HTML.hr())
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append(HTML.hr())
							.append(HTML.tdEnd())
							.append(HTML.trEnd());
		}

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("Prefix", "prefix"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input("text","prefix","prefix", prefix))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		HashMap<String, String> map = props.getProperties(prefix);
		for (String key : props.getPropertyOrderList()) {
			if (!map.containsKey(key)) {
				continue;
			}

			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append(HTML.label(key, key))
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append(HTML.input("text", key, key,map.get(key)))
							.append(HTML.tdEnd())
							.append(HTML.trEnd());
		}

		for (int i=0; i<4; i++) {
			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append(HTML.input(
											"text",
											"new-property-" + i,
											"new-property-" + i,
											""))
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append(HTML.input(
											"text",
											"new-value-" + i,
											"new-value-" + i,
											""))
							.append(HTML.tdEnd())
							.append(HTML.trEnd());
		}

		contentBuilder
						.append(HTML.tableEnd())
						.append(HTML.input(
										"submit",
										"submit-prefix-editor",
										"submit",
										"Submit"))
						.append(HTML.formEnd())
						.append(HTML.htmlEnd());

		return contentBuilder.toString();

	}

}

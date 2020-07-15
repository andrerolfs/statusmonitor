package de.wartbar.html;

import de.wartbar.common.WartbarBase;

public class SelectPrefix extends WartbarBase {

	public static String getSelectPrefix() {

		props.updateDemoData();

		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(HTML.docType())
						.append(HTML.htmlBegin())
						.append(HTML.headBegin())
						.append(HTML.metaContentTypeApplicationJson())
						.append(HTML.title("Select Prefix"))
						.append(HTML.headEnd())
						.append(HTML.bodyBegin())
						.append(HTML.H1("Select a prefix to edit"))
						.append(HTML.br())
						.append(HTML.a("Link List", "http://localhost:8080/links"))
						.append(HTML.br())
						.append(HTML.br())
						.append(HTML.formBegin("http://localhost:8080/editPrefix", "get"))
						.append(HTML.tableBegin(""));

		for (String key : props.getPrefixOrder()) {
			contentBuilder.append(HTML.trBegin())
							.append(HTML.tdBegin(""))
							.append(HTML.label("Edit", "submit_" + key))
							.append(HTML.tdEnd())
							.append(HTML.tdBegin(""))
							.append(HTML.input(
											"submit",
											"submit_" + key,
											"prefix",
											key))
							.append(HTML.tdEnd())
							.append(HTML.trEnd());
		}

		contentBuilder.append(HTML.trBegin())
						.append(HTML.tdBegin(""))
						.append(HTML.label("Edit new prefix", "submit_new-prefix"))
						.append(HTML.tdEnd())
						.append(HTML.tdBegin(""))
						.append(HTML.input(
										"submit",
										"submit_new-prefix",
										"prefix",
										"New Prefix"))
						.append(HTML.tdEnd())
						.append(HTML.trEnd());

		contentBuilder
						.append(HTML.tableEnd())
						.append(HTML.formEnd())
						.append(HTML.htmlEnd());

		return contentBuilder.toString();
	}

}
package de.wartbar.html;

import de.wartbar.common.WartbarBase;

public class PropertyOrderEditor extends WartbarBase {

	public static String getPropertyOrderEditor() {
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(HTML.docType())
						.append(HTML.htmlBegin())
						.append(HTML.headBegin())
						.append(HTML.metaContentTypeApplicationJson())
						.append(HTML.title("Property Order Editor"))
						.append(HTML.headEnd())
						.append(HTML.bodyBegin())
						.append(HTML.formBegin("http://localhost:8080/propertiesOrder", "post"))
						.append(HTML.H1("The order of your properties"))
					  .append(HTML.br())
						.append(HTML.a("Link List", "http://localhost:8080/links"))
						.append(HTML.br())
						.append(HTML.br());

		Integer counter = 0;
		for (String key : props.getPropertyOrderList()) {

			contentBuilder.append(HTML.input("text",
							"input" + counter.toString(),
							"input" + counter.toString(),
							""))
							.append(HTML.br())
							.append(HTML.br());
			counter++;

			contentBuilder.append(HTML.input("text",
							"input" + counter.toString(),
							"input" + counter.toString(),
							key))
							.append(HTML.br())
							.append(HTML.br());
			counter++;

		}

		contentBuilder.append(HTML.input("text",
						"input" + counter.toString(),
						"input" + counter.toString(),
						""))
						.append(HTML.br())
						.append(HTML.br());

		contentBuilder.append(HTML.input("submit", "Submit", "Submit", "Submit"))
						.append(HTML.formEnd())
						.append(HTML.htmlEnd());

		return contentBuilder.toString();
	}

}

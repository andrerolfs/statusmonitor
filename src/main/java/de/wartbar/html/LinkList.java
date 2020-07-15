package de.wartbar.html;

public class LinkList {

	public static String getLinkList() {

		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append(HTML.docType())
						.append(HTML.htmlBegin())
						.append(HTML.headBegin())
						.append(HTML.metaContentTypeApplicationJson())
						.append(HTML.title("Link List + Documentation"))
						.append(HTML.headEnd())
						.append(HTML.bodyBegin())
						.append(HTML.H1("LinkList"))
						.append(HTML.a("Property Order Editor", "http://localhost:8080/propertiesOrder"))
						.append(HTML.br())
						.append(HTML.a("Select Prefix", "http://localhost:8080/selectPrefix"))
						.append(HTML.br())
						.append(HTML.a("Status Monitor", "http://localhost:8080/status"))
						.append(HTML.hr())
						.append("Documentation")
						.append(HTML.hr())
						.append(HTML.ulBegin())
						.append(HTML.liBegin())
						.append("To change the tool configuration click : Select Prefix / Wartbar")
						.append(HTML.liEnd())
						.append(HTML.liBegin())
						.append("To add some demo data click : Select Prefix / Wartbar / demo = true")
						.append(HTML.liEnd())
						.append(HTML.liBegin())
						.append("To show the status monitor click : Status Monitor")
						.append(HTML.liEnd())
						.append(HTML.liBegin())
						.append("To define the order of properties of a prefix click : Property Order Editor")
						.append(HTML.liEnd())
						.append(HTML.ulEnd())
						.append(HTML.hr())
						.append(HTML.htmlEnd());

		return  contentBuilder.toString();
	}
}

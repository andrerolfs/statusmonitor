package de.wartbar.html;

import java.util.List;

public class StatusMonitor extends HTML {

	private static String getHeader() {
		return new StringBuilder()
						.append("<!DOCTYPE html>").append(nl)
						.append("<html>").append(nl)
						.append("  <head>").append(nl)
						.append("    <style>").append(nl)
						.append("      #width100Perecent {").append(nl)
						.append("        width: 100%;").append(nl)
						.append("      }").append(nl)
						.append("      #inner {").append(nl)
						.append("        border-radius: 10px;").append(nl)
						.append("        background: #000099;").append(nl)
						.append("        padding: 40px;").append(nl)
						.append("        color: white").append(nl)
						.append("      }").append(nl)
						.append("      #outer {").append(nl)
						.append("        border-radius: 50px;").append(nl)
						.append(CSS.getBackgroundByProperty()).append(nl)
						.append("        padding: 40px;").append(nl)
						.append("        color: white").append(nl)
						.append("      }").append(nl)
						.append("      body {").append(nl)
						.append("        background-color: #000000;").append(nl)
						.append("        color: white;").append(nl)
						.append("      }").append(nl)
						.append("    </style>").append(nl)
						.append("  </head>").append(nl)
						.toString();
	}

	public static String getStatusMonitor() {

		props.updateDemoData();

		StringBuilder contentBuilder = new StringBuilder();

		contentBuilder
						.append(getHeader())
						.append(HTML.bodyBegin())
						.append(HTML.H1("Status Monitor"))
						.append(HTML.br())
						.append(HTML.a("Link List", "http://localhost:8080/links"))
						.append(HTML.br())
						.append(HTML.br())
						.append(HTML.tableBegin("outer"))
						.append(HTML.trBegin());

		Integer dimension = props.getStatusMonitorDimension();
		List<String> prefixList = props.getPrefixOrder();

		List<String> propertyOrderList = props.getPropertyOrderList();
		int rowSize = 0;
		for (String prefix : prefixList) {
			if (prefix.equals("wartbar")) {
				continue;
			}

			contentBuilder.append(HTML.tile(prefix, props.getProperties(prefix), propertyOrderList));
			rowSize++;
			if(rowSize == dimension) {
				contentBuilder.append(HTML.trEnd());
				contentBuilder.append(HTML.trBegin());
				rowSize = 0;
			}
		}

		contentBuilder
						.append(HTML.trEnd())
						.append(HTML.tableEnd())
						.append(HTML.bodyEnd())
						.append(HTML.htmlEnd());


		return contentBuilder.toString();
	}
}

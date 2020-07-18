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
						.append("      .ui-progressbar {").append(nl)
						.append("      position: relative;").append(nl)
						.append("      color:#ffffff;").append(nl)
						.append("      width:100%;").append(nl)
						.append("      margin-left:auto;").append(nl)
						.append("      margin-right:auto;").append(nl)
						.append("      }").append(nl)
						.append("      .progress-label {").append(nl)
						.append("      position: absolute;").append(nl)
						.append("      left: 50%;").append(nl)
						.append("      top: 4px;").append(nl)
						.append("      margin-left:-40px;").append(nl)
						.append("      }").append(nl)
						.append("      .ui-widget-header {").append(nl)
						.append("      border: 13px solid #00aa00;").append(nl)
						.append("      background: #C3AEE0").append(nl)
						.append("      margin-left:-40px;").append(nl)
						.append("      }").append(nl)
						.append("    </style>").append(nl)
						.append("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>").append(nl)
						.append("    <script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js\"></script>").append(nl)
						.append("    <script src=\"js/statusmonitor.js\"></script>").append(nl)
						.toString();
	}

	public static String getStatusMonitor() {

		props.updateDemoData();

		StringBuilder contentBuilder = new StringBuilder();

		contentBuilder
						.append(getHeader())
						.append(HTML.headEnd()).append(nl)
						.append(HTML.bodyBegin())
						.append(HTML.H1("Status Monitor"))
						.append(HTML.br()).append(nl)

						/*
						.append("	<button>Stop Reload</button>").append(nl)
						.append(HTML.br()).append(nl)
						.append(HTML.br()).append(nl)
						.append("<div id=\"progressbar\"><div class=\"progress-label\"></div></div>").append(nl)
						.append(HTML.br()).append(nl)
						 */
						
						.append(HTML.br()).append(nl)
						.append(HTML.a("Link List", "http://localhost:8080/links")).append(nl)
						.append(HTML.br()).append(nl)
						.append(HTML.br()).append(nl)
						.append(HTML.tableBegin("outer")).append(nl)
						.append(HTML.trBegin()).append(nl);

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

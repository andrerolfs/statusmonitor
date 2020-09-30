package de.wartbar.common;

public class HTMLToolBox {

	public static String htmlEncode(String input) {
		return input
						.replace("&", "&amp;")
						.replace("<", "&lt;")
						.replace("\"", "&quot;")
						.replace(">", "&gt;");
	}

	public static String whitespaceToUnderscore(String input) {
		return input
						.replace(" ", "_");
	}
}

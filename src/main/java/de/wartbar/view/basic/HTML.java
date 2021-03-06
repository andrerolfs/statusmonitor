package de.wartbar.view.basic;

import de.wartbar.common.HTMLToolBox;
import de.wartbar.common.WartbarBase;
import java.util.HashMap;
import java.util.List;

public class HTML extends WartbarBase {

	public static String label(String label, String for_id) {
		return "<label for=\"" + HTMLToolBox.whitespaceToUnderscore(for_id) + "\">" + label + "</label>" + nl;
	}

	public static String htmlBegin() {
		return "<html lang=\"en\">" + nl;
	}
	public static String htmlEnd() {
		return "</html>" + nl;
	}

	public static String bodyBegin() {
		return "<body>" + nl;
	}
	public static String bodyEnd() {
		return "</body>" + nl;
	}

	public static String ulBegin() {
		return "<ul>" + nl;
	}
	public static String ulEnd() {
		return "</ul>" + nl;
	}

	public static String liBegin() {
		return "<li>" + nl;
	}
	public static String liEnd() {
		return "</li>" + nl;
	}

	public static String metaContentTypeApplicationJson() {
		return "<meta http-equiv=\"Content-Type\" content=\"application/json\">" + nl;
	}

	public static String docType() {
		return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">" + nl;
	}

	public static String formBegin(String url, String method) {
		return "<form action=\"" + url + "\" method=\"" + method + "\">" +nl;
	}
	public static String formEnd() {
		return "<form/>" +nl;
	}

	public static String input(String type, String id, String name, String value) {
		return "<input size=\"60\" type=\"" + type + "\" id=\"" + HTMLToolBox.whitespaceToUnderscore(id) + "\" name=\"" + name + "\" value=\"" + value + "\">" + nl;
	}

	public static String br() {
		return "<br/>" + nl;
	}
	public static String H1(String name) {
		return "<H1>" + name + "</H1>" +nl;
	}

	public static String title(String title) {
		return "<title>" + title + "</title>" + nl;
	}
	public static String tableBegin(String id) {
		return "<table id=\"" + HTMLToolBox.whitespaceToUnderscore(id) + "\">" + nl;
	}

	public static String tableEnd() {
		return "</table>" + nl;
	}

	public static String trBegin() {
		return "<tr>" + nl;
	}
	public static String trEnd() {
		return "</tr>" + nl;
	}

	public static String tdBegin(String id) {
		return "<td id=\"" + HTMLToolBox.whitespaceToUnderscore(id) + "\">" + nl;
	}
	public static String tdBegin(String id, int colspan) {
		return "<td id=\"" + id + "\" colspan=\"" + colspan + "\">" + nl;
	}
	public static String tdEnd() {
		return "</td>" + nl;
	}

	public static String headBegin() {
		return "<head>" + nl;
	}
	public static String headEnd() {
		return "</head>" + nl;
	}

	public static String styleBegin() {
		return "<style>" + nl;
	}
	public static String styleEnd() {
		return "</style>" + nl;
	}


	public static String a(String text, String link) {
		return "<a href=\"" + link + "\">" + text + "</a>" + nl;
	}

	public static String hr() {
		return "<hr>" + nl;
	}
}

package de.wartbar.common;

import org.springframework.web.util.UriUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class URLToolbox {

	public static List<WartbarPair<String>> decodeBody(String body) {
		List<WartbarPair<String>> list = new ArrayList<>();
		String[] parts = body.split("&");

		for (String pair : parts) {
			String[] splitPair = pair.split("=");

			if (splitPair.length == 1) {
				continue;
			}

			if (splitPair[1].equals("Submit")) {
				continue;
			}

			list.add(new WartbarPair<>(decodeUrlParameter(splitPair[0]), decodeUrlParameter(splitPair[1])));
		}
		return list;
	}

	public static List<WartbarPair<String>> decodeBody(Map<String,String> body) {
		List<WartbarPair<String>> list = new ArrayList<>();

		for (String key : body.keySet()) {
			list.add(new WartbarPair<>(decodeUrlParameter(key), decodeUrlParameter(body.get(key))));
		}

		return list;
	}

	public static String decodeUrlParameter(String urlParameter) {
		return UriUtils.decode(urlParameter, "UTF-8");
	}


}

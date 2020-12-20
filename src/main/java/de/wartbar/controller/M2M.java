package de.wartbar.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.wartbar.model.WartbarApplication;
import de.wartbar.model.basic.WartbarSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class M2M extends de.wartbar.common.WartbarBase {

	Logger logger = LoggerFactory.getLogger(de.wartbar.controller.M2M.class);

	@GetMapping("/m2m")
	public String pop(@RequestParam Map<String,String> body) {
		logger.info("M2M.pop");
		//List<WartbarPair<String>> bodyPairList = URLToolbox.decodeBody(body);
		String sectionName = body.get("Section");
		String subSectionName = body.get("SubSection");

		HashMap<String, String> map = WartbarApplication.cloneSubSection(sectionName, subSectionName);
		WartbarApplication.removeSubSection(sectionName, subSectionName);

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);

		return json;
	}

	@PostMapping("/m2m")
	public String post(@RequestParam Map<String,String> body) {
		//List<WartbarPair<String>> bodyPairList = URLToolbox.decodeBody(body);
		int level = Integer.parseInt(body.get("Level"));
		String sectionName = body.get("Section");
		String subSectionName = body.get("SubSection");
		String key = body.get("Key");
		String value = body.get("Value");
		String background = body.get("Background");

		int backgroundColor = Integer.parseInt(background);

		logger.info("M2M.postProperty" +
						level + ":" +
						sectionName + ":" +
						subSectionName + ":" +
						key + ":" +
						value + ":" + backgroundColor);

		WartbarSection section = WartbarApplication.putIfAbsent(sectionName, level);
		section.setTileBackground(backgroundColor);
		section.putProperty(subSectionName, key, value);
		return "post done";
	}

}

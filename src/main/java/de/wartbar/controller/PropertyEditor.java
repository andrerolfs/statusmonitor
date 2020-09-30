package de.wartbar.controller;

import de.wartbar.common.URLToolbox;
import de.wartbar.common.WartbarPair;
import de.wartbar.model.WartbarApplication;
import de.wartbar.model.basic.WartbarSection;
import de.wartbar.model.basic.WartbarSubSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PropertyEditor extends de.wartbar.common.WartbarBase {

	Logger logger = LoggerFactory.getLogger(de.wartbar.controller.PropertyEditor.class);

	@GetMapping("/propertyeditor")
	public String getPropertyEditor() {
		logger.info("PropertyEditor.getPropertyEditor");
		return de.wartbar.view.Property.getPropertyEditor();
	}

	@PostMapping("/propertyeditor")
	public String postPropertyEditor(@RequestParam Map<String,String> body) {
		List<WartbarPair<String>> bodyPairList = URLToolbox.decodeBody(body);
		int level = Integer.parseInt(body.get("Level"));
		String sectionName = body.get("Section");
		String subSectionName = body.get("SubSection");
		String key = body.get("Key");
		String value = body.get("Value");
		String background = body.get("Background");

		int backgroundColor = Integer.parseInt(background);

		logger.info("PropertyEditor.postPropertyEditor " +
						level + ":" +
						sectionName + ":" +
						subSectionName + ":" +
						key + ":" +
						value + ":" + backgroundColor);

		WartbarSection section = WartbarApplication.putIfAbsent(sectionName, level);
		section.setTileBackground(backgroundColor);
		section.putProperty(subSectionName, key, value);
		return de.wartbar.view.Property.getPropertyEditor();
	}

}

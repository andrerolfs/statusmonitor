package de.wartbar.controller;

import de.wartbar.common.URLToolbox;
import de.wartbar.common.WartbarPair;
import de.wartbar.model.WartbarApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LevelEditor extends de.wartbar.common.WartbarBase {

	Logger logger = LoggerFactory.getLogger(de.wartbar.controller.LevelEditor.class);

	@GetMapping("/leveleditor")
	public String getLevelEditor() {
		logger.info("LevelEditor.getLevelEditor : ");
		return de.wartbar.view.Level.getLevelEditor();
	}

	@PostMapping("/leveleditor")
	public String postLevelEditor(@RequestParam Map<String,String> body) {
		List<WartbarPair<String>> bodyPairList = URLToolbox.decodeBody(body);
		int level = Integer.parseInt(body.get("Level"));
		String name = body.get("Name");
		int background = Integer.parseInt(body.get("Background"));
		logger.info("LevelEditor.postLevelEditor " + level + ":" + name + ":" + background);
		WartbarApplication.setLevel(level, name, background);
		return de.wartbar.view.Level.getLevelEditor();
	}

}

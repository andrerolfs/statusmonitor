package de.wartbar.controller;

import de.wartbar.common.URLToolbox;
import de.wartbar.common.WartbarPair;
import de.wartbar.model.WartbarApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StatusMonitor extends de.wartbar.common.WartbarBase {

	Logger logger = LoggerFactory.getLogger(de.wartbar.controller.StatusMonitor.class);

	@GetMapping("/statusmonitor")
	public String getStatusMonitor(@RequestParam Map<String,String> body) {
		List<WartbarPair<String>> bodyPairList = URLToolbox.decodeBody(body);
		int level = Integer.parseInt(body.get("Level"));
		logger.info("StatusMonitor.getStatusMonitor : " + level);
		return de.wartbar.view.StatusMonitor.getStatusMonitor(WartbarApplication.getUpdateOrder(level), level);
	}

}

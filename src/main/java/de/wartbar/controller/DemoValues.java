package de.wartbar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoValues extends de.wartbar.common.WartbarBase {

	Logger logger = LoggerFactory.getLogger(de.wartbar.controller.DemoValues.class);

	@GetMapping("/demovalues")
	public String addDemoValues() {
		logger.info("addDemoValues");
		de.wartbar.common.DemoValues.addDemoValues();
		return de.wartbar.view.LinkList.getLinkList();
	}

}

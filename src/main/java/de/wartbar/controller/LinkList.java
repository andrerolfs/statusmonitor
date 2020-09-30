package de.wartbar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkList extends de.wartbar.common.WartbarBase {

	Logger logger = LoggerFactory.getLogger(de.wartbar.controller.StatusMonitor.class);

	@GetMapping("/links")
	public String getLinks() {
		logger.info("LinkList.links");
		return de.wartbar.view.LinkList.getLinkList();
	}

}

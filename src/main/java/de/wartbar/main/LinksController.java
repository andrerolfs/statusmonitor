package de.wartbar.main;

import de.wartbar.html.LinkList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinksController {

	Logger logger = LoggerFactory.getLogger(LinksController.class);

	@GetMapping("/links")
	public String linksGet() {

		logger.info("LinksController.linksGet");
		return LinkList.getLinkList();
	}

}

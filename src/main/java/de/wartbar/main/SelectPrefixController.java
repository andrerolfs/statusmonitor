package de.wartbar.main;

import de.wartbar.html.SelectPrefix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelectPrefixController extends de.wartbar.common.WartbarBase{

	Logger logger = LoggerFactory.getLogger(SelectPrefixController.class);

	@GetMapping("/selectPrefix")
	public String selectPrefixGet() {
		logger.info("SelectPrefixController.selectPrefixGet");
		synchronized (Sync.SYNC_POINT) {
			return SelectPrefix.getSelectPrefix();
		}
	}

}

package de.wartbar.main;

import de.wartbar.html.StatusMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController extends de.wartbar.common.WartbarBase{

	Logger logger = LoggerFactory.getLogger(StatusController.class);

	@GetMapping("/status")
	public String statusGet() {
		logger.info("StatusController.statusGet");
		synchronized (Sync.SYNC_POINT) {
			return StatusMonitor.getStatusMonitor();
		}
	}

	@GetMapping("/update")
	public String updateGet() {
		logger.info("StatusController.updateGet");
		synchronized (Sync.SYNC_POINT) {
			return "true";
		}
	}

}

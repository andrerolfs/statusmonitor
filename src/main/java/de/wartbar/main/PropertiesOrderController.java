package de.wartbar.main;

import de.wartbar.common.URLToolbox;
import de.wartbar.html.PropertyOrderEditor;
import de.wartbar.common.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PropertiesOrderController extends de.wartbar.common.WartbarBase{

	Logger logger = LoggerFactory.getLogger(PropertiesOrderController.class);

	@GetMapping("/propertiesOrder")
	public String prefixGet() {
		logger.info("PropertiesOrderController.prefixGet");
		synchronized (Sync.SYNC_POINT) {
			return PropertyOrderEditor.getPropertyOrderEditor();
		}
	}

	@PostMapping("/propertiesOrder")
	public String prefixPost(@RequestParam Map<String,String> body) {
		logger.info("PropertiesOrderController.prefixPost");
		synchronized (Sync.SYNC_POINT) {
			List<String> list = new ArrayList<>();
			List<Pair<String>> bodyPairList = URLToolbox.decodeBody(body);
			for (Pair<String> p : bodyPairList) {
				String value = p.getValue();

				if (value.isEmpty()) {
					continue;
				}

				if (value.equals("Submit")) {
					continue;
				}

				list.add(value);
				logger.info("PropertiesOrderController.prefixPost : param " + p.getKey() + " : " + value);
			}

			props.setPropertyOrderList(list);
			return PropertyOrderEditor.getPropertyOrderEditor();
		}
	}
}

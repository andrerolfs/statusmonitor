package de.wartbar.main;

import de.wartbar.common.URLToolbox;
import de.wartbar.html.PrefixEditor;
import de.wartbar.common.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EditPrefixController extends de.wartbar.common.WartbarBase {


	Logger logger = LoggerFactory.getLogger(EditPrefixController.class);

	@GetMapping("/editPrefix")
	public String selectPrefixGet(@RequestParam String prefix) {
		synchronized (Sync.SYNC_POINT) {
			return PrefixEditor.getEditPrefix(prefix);
		}
	}

	@PostMapping("/editPrefix")
	public String prefixPost(@RequestParam Map<String,String> body) {
		logger.info("EditPrefixController.prefixPost");
		synchronized (Sync.SYNC_POINT) {
			String prefix = "";
			String keyNewProperty = "";

			List<Pair<String>> bodyPairList = URLToolbox.decodeBody(body);
			for (Pair<String> p : bodyPairList) {
				logger.info("EditPrefixController.prefixPost : param " + p.getKey() + " : " + p.getValue());
				if (p.getKey().equals("prefix")) {
					prefix = p.getValue();
				} else if (p.getKey().startsWith("new-property-")) {
					keyNewProperty = p.getValue();
				} else if (p.getKey().startsWith("new-value-")) {
					if (keyNewProperty.isEmpty()) {
						continue;
					}
					props.setProperty(prefix, keyNewProperty, p.getValue());
				} else if (p.getKey().equals("submit")) {
					continue;
				} else {
					props.setProperty(prefix, p.getKey(), p.getValue());
				}
			}

			return PrefixEditor.getEditPrefix(prefix);
		}
	}

}

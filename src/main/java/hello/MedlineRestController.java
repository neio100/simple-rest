package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MedlineRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedlineRestController.class);
	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "I am making a production change";
	}

	@PostMapping("/messages/audit")
	public ResponseEntity<String> reactiveSendMessage(@RequestParam String message) {
		LOGGER.info("Audit message to send message: {} to destination.", message);
		//many.emitNext(MessageBuilder.withPayload(message).build(), Sinks.EmitFailureHandler.FAIL_FAST);
		return ResponseEntity.ok(message);
	}
}

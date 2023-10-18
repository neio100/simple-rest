package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MedlineRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedlineRestController.class);
	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello World ; This is new change";
	}

	@PostMapping("/messages/audit")
	public ResponseEntity<String> reactiveSendMessage(@RequestParam String message) {
		LOGGER.info("Audit message to send message: {} to destination.", message);
		//many.emitNext(MessageBuilder.withPayload(message).build(), Sinks.EmitFailureHandler.FAIL_FAST);
		return ResponseEntity.ok(message);
	}

	@GetMapping("/serviceA")
	public String getServiceA(){
		return "This is a result of Service A";
	}

	@GetMapping("/env")
	public Map<String, String> getEnv(){
		Map<String, String> env = System.getenv();
		return env;
	}
}

package main.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/test-docker")
	public String getData() {
		return "Greetings folks. Wecome to Spring Boot!";
	}

}
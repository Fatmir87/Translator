package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
//Controller
@RestController
public class LangController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

//I18N (Internationalization) 
	@GetMapping(path = "/hello-world-I18N")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestParam(value = "word") String word) {

		// Converting the properties word to JSON
		return "{ \"" + word + "\" : \"" + messageSource.getMessage(word + ".message", null, "Error", locale) + "\" }";
	}
}
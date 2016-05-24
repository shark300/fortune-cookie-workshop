package io.github.kicsikrumpli.controller;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.kicsikrumpli.service.FortuneCookieService;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	@Autowired
	private FortuneCookieService fortuneCookieService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> home() {
		String cookieMessage = fortuneCookieService.fetchRandomFortuneCookie();
		logger.info("fortune cookie: {}", cookieMessage);
		return Collections.singletonMap("fortuneCookie", cookieMessage);
	}
	
}

package io.github.kicsikrumpli.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FortuneCookieService {
	private final RestTemplate restTemplate = new RestTemplate();
	
	public String fetchRandomFortuneCookie() {
		ResponseEntity<FortuneCookie[]> cookie = restTemplate.getForEntity("http://fortunecookieapi.com/v1/cookie", FortuneCookie[].class);
		return cookie.getBody()[0].getFortune().getMessage();
	}
}

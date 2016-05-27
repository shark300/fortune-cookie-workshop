package io.github.kicsikrumpli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeControllerIT {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeControllerIT.class);
	private static final String LOCALHOST_IT = "http://localhost:9998/";
	
	@Test
	public void testPing() {
		// GIVEN
		RestTemplate restTemplate = new RestTemplate();
		LOGGER.info("GETting url {}", LOCALHOST_IT);
		
		// WHEN
		ResponseEntity<String> result = restTemplate.getForEntity(LOCALHOST_IT, String.class);
		
		// THEN
		LOGGER.info("Result [{}]: {}", result.getStatusCode(), result.getBody());
		Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
	}
}

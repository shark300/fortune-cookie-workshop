package io.github.kicsikrumpli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import it.spring.config.ItSpringConfigBootstrap;

@ContextConfiguration(
	    loader = AnnotationConfigContextLoader.class,
	    classes = {ItSpringConfigBootstrap.class})
public class HomeControllerIT extends AbstractTestNGSpringContextTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeControllerIT.class);
	@Value("${IT.URL}")
	private String itUrl;
	@Value("${MOCK.FORTUNECOOKIE.MESSAGE}")
	private String expectedMessage;
	
	@Test
	public void testPing() {
		// GIVEN
		RestTemplate restTemplate = new RestTemplate();
		LOGGER.info("GETting url {}", itUrl);
		
		// WHEN
		ResponseEntity<FortuneCookie> result = restTemplate.getForEntity(itUrl, FortuneCookie.class);
		
		// THEN
		LOGGER.info("Result [{}]: {}", result.getStatusCode(), result.getBody());
		Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(result.getBody().getFortuneCookie(), expectedMessage);
	}
	
	public static class FortuneCookie {
		private String fortuneCookie;

		public String getFortuneCookie() {
			return fortuneCookie;
		}

		public void setFortuneCookie(String fortuneCookie) {
			this.fortuneCookie = fortuneCookie;
		}
	}
}

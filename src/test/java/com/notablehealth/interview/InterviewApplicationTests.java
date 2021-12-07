package com.notablehealth.interview;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InterviewApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	public InterviewApplicationTests(){
	}

	@Test
	public void getDoctors() throws URISyntaxException {
		final String baseURL = "http://localhost:" + port +"/doctors";
		URI url = new URI(baseURL);

		ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		Assert.assertEquals (HttpStatus.OK, result.getStatusCode());
	}
}

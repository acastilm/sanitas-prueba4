package com.sanitas.prueba4.rest;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OperacionAritmeticaRestControllerTest {

	@Autowired
	OperacionAritmeticaController opRestController;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void test_whenSuccess_shouldReturnResponseOK() throws Exception{
		
		String operacion = "suma";
		String [] operandos = givenTwoOperands();
		String url = "http://localhost:" + port + "/v1/rest/calculadora?operacion={nombreOperacion}&operandos={operandos}";
		
		Assertions.assertAll(
			() -> Assertions.assertTrue(this.restTemplate.getForEntity(url,
				ResultadoWrapper.class, operacion, operandos).getStatusCode().equals(HttpStatus.OK)),		
				
			() ->Assertions.assertTrue(this.restTemplate.getForEntity(url,
				ResultadoWrapper.class, operacion, operandos).getBody().getResultado().compareTo(givenAddResult())==0)
		);
	}
	
	@Test
	public void test_whenNoNumericOperands_shouldReturnResponseBadRequest() throws Exception{
		
		String operacion = "suma";
		String [] operandos = givenTwoOperandsNotNumerics();
		String url = "http://localhost:" + port + "/v1/rest/calculadora?operacion={nombreOperacion}&operandos={operandos}";
		Assertions.assertTrue(this.restTemplate.getForEntity(url,
				ResultadoWrapper.class, operacion, operandos).getStatusCode().equals(HttpStatus.BAD_REQUEST));						
	}
	
	@Test
	public void test_whenNotTwoOperands_shouldReturnResponseBadRequest() throws Exception{
		
		String operacion = "suma";
		String [] operandos = givenThreeOperands();		
		String url = "http://localhost:" + port + "/v1/rest/calculadora?operacion={nombreOperacion}&operandos={operandos}";
		
		Assertions.assertTrue(this.restTemplate.getForEntity(url,
				ResultadoWrapper.class, operacion, operandos).getStatusCode().equals(HttpStatus.BAD_REQUEST));		
	}
		
	private String [] givenTwoOperands() {
		return new String []{"2.4","3"};
	}
	
	private BigDecimal givenAddResult() {
		return new BigDecimal("5.4");
	}
	
	private String [] givenTwoOperandsNotNumerics() {
		return new String []{"2.4aa","3bb"};
	}
	private String [] givenThreeOperands() {
		return new String []{"2.4","3","3"};
	}	
	 
}

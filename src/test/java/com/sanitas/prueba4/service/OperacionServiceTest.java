package com.sanitas.prueba4.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sanitas.prueba4.model.OperacionBuilder;

public class OperacionServiceTest {

	static OperacionesServiceImpl operacionesServices;
	
	 @BeforeAll
	 public static void setUp() throws Exception {
		 operacionesServices = new OperacionesServiceImpl();
		 operacionesServices.setOpBuilder(new OperacionBuilder());
	   }
	 
	@Test
	public void testShouldAddTwoOperands() {
	
		String operacion = "suma";
		BigDecimal[] operandos = {new BigDecimal("3.222"), new BigDecimal("5.222")};
		BigDecimal resultadoEsperado = new BigDecimal("8.444");
		Assertions.assertTrue(operacionesServices.ejecutaOperacion(operacion, operandos).getResultado().compareTo(resultadoEsperado)==0) ;
	}
	
	@Test
	public void testShouldSubstractTwoOperands() {
	
		String operacion = "resta";
		BigDecimal[] operandos = {new BigDecimal("3.222"), new BigDecimal("5.222")};
		BigDecimal resultadoEsperado = new BigDecimal("-2");
		
		Assertions.assertTrue(operacionesServices.ejecutaOperacion(operacion, operandos).getResultado().compareTo(resultadoEsperado)==0) ;
	}
	
	@Test
	public void testShouldThrowExceptionWithUnknownOperation() {
	
		String operacion = "desconocida";
		BigDecimal[] operandos = {new BigDecimal(3.222), new BigDecimal(5.222)};
		
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 	operacionesServices.ejecutaOperacion(operacion, operandos);
	          }, "Debe lanzar excepción si la operacion no está implementada");
	}
	
}

package com.sanitas.prueba4.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperacionBuilderTest {
	
	@Test
	public void testShouldBuildOperacionSuma() throws Exception {	   
	
	 String operacion = OperacionBuilder.OPERACIONES.suma.toString();
	 BigDecimal[] operandos = {new BigDecimal(4), new BigDecimal(2)};
	 
	 OperacionBuilder builder = new OperacionBuilder();
	 Operacion suma = builder.withOperacion(operacion).setOperandos(operandos).build();
	 
	 Assertions.assertTrue(suma instanceof OperacionSuma, "Debe crear un objeto de tipo OperacionSuma");	 
	}	 
	 
	@Test
	public void testShouldBuildOperacionResta() throws Exception {	   
	
	 String operacion = OperacionBuilder.OPERACIONES.resta.toString();
	 BigDecimal[] operandos = {new BigDecimal(4), new BigDecimal(2)};
	 
	 OperacionBuilder builder = new OperacionBuilder();
	 Operacion resta = builder.withOperacion(operacion).setOperandos(operandos).build();
	 
	 Assertions.assertTrue(resta instanceof OperacionResta, "Debe crear un objeto de tipo OperacionResta");	 		
	}
	

	@Test
	public void testShouldThrowExceptionIfOnlyOneOperand() throws Exception {	   
	
	 String operacion = OperacionBuilder.OPERACIONES.suma.toString();
	 BigDecimal[] operandos = {new BigDecimal(4)};
	 
	 OperacionBuilder builder = new OperacionBuilder();
	 
	 Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  builder.withOperacion(operacion).setOperandos(operandos).build();
       }, "Debe lanzar excepción si sólo se recibe un operando");	 	 	
	}	
	
	@Test
	public void testShouldThrowExceptionIfMoreThanTwoOperands() throws Exception {	   
	
	 String operacion = OperacionBuilder.OPERACIONES.suma.toString();
	 BigDecimal[] operandos = {new BigDecimal(4), new BigDecimal(4), new BigDecimal(4)};
	 
	 OperacionBuilder builder = new OperacionBuilder();
	 
	 Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  builder.withOperacion(operacion).setOperandos(operandos).build();
       }, "Debe lanzar excepción si se recibe más de un operando");	 	 	
	}	
	
	@Test
	public void testShouldThrowExceptionWithUnknownOperation() throws Exception {	   
	
	 String operacion = "desconocida";
	 BigDecimal[] operandos = {new BigDecimal(4), new BigDecimal(2)};
	 
	 OperacionBuilder builder = new OperacionBuilder();
	 
	  Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  builder.withOperacion(operacion).setOperandos(operandos).build();
        }, "Debe lanzar excepción si la operación no está implementada.");	  	  		
	}
	
}

package com.sanitas.prueba4.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperacionSumaTest {
	 	
	    @Test
	    public void testFistOperandNullIsNotAllowed() throws Exception {	        	        
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            new OperacionSuma(null,new BigDecimal(5));
	          }, "Debe lanzar excepción si el primer operando es null.");	        	        
	    }
	    
	    @Test
	    public void testSecondOperandNullIsNotAllowed() throws Exception {	        	        
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            new OperacionSuma(new BigDecimal(5), null);
	          }, "Debe lanzar excepción si el segundo operando es null.");	        	        
	    }
	    
	    @Test
	    public void testShouldAddOperands() throws Exception {	        	        
	        
	    	OperacionSuma suma = new OperacionSuma(new BigDecimal(5), new BigDecimal(3));
	    	
	    	Assertions.assertTrue(new BigDecimal(8).compareTo(suma.execute())==0, "Error al sumar números enteros");	    		        	       
	    }
	    
	    @Test
	    public void testShouldAddOperandsWithDecimals() throws Exception {	        	        
	        
	    	OperacionSuma suma = new OperacionSuma(new BigDecimal(5.222233331), new BigDecimal(3.222233331));
	    	
	    	Assertions.assertTrue(new BigDecimal(8.444466662).compareTo(suma.execute())==0, "Error al sumar con decimales");	    		        	       
	    }
	    
	    @Test
	    public void testShouldAddNegativeOperands() throws Exception {	        	        
	        
	    	OperacionSuma suma = new OperacionSuma(new BigDecimal(-5.222233331), new BigDecimal(-3.222233331));
	    	
	    	Assertions.assertTrue(new BigDecimal(-8.444466662).compareTo(suma.execute())==0, "Error al sumar números negativos");	    		        	       
	    }	    
}

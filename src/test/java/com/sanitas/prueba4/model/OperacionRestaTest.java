package com.sanitas.prueba4.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperacionRestaTest {

	 @Test
	    public void testFistOperandNullIsNotAllowed() throws Exception {	        	        
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            new OperacionResta(null,new BigDecimal(5));
	          }, "Debe lanzar excepción si el primer operando es null.");	        	        
	    }
	    
	    @Test
	    public void testSecondOperandNullIsNotAllowed() throws Exception {	        	        
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            new OperacionResta(new BigDecimal(5), null);
	          }, "Debe lanzar excepción si el segundo operando es null.");	 	        	        
	    }
	    
	    @Test
	    public void testShouldSubstractOperands() throws Exception {	        	        
	        
	    	OperacionResta resta = new OperacionResta(new BigDecimal(5), new BigDecimal(3));
	    	
	    	Assertions.assertTrue(new BigDecimal(2).compareTo(resta.execute())==0, "La resta de dos números no es correcta.");	    		        	       
	    }
	    
	    @Test
	    public void testShouldSubstractOperandsWithDecimals() throws Exception {	        	        
	        
	    	OperacionResta resta = new OperacionResta(new BigDecimal(5.222233331), new BigDecimal(3.222233331));
	    	
	    	Assertions.assertTrue(new BigDecimal(2).compareTo(resta.execute())==0, "La resta de dos números con decimales no es correcta.");		    		        	       
	    }
	    
	    @Test
	    public void testShouldSubstractNegativeOperands() throws Exception {	        	        
	        
	    	OperacionResta resta = new OperacionResta(new BigDecimal(-5.222233331), new BigDecimal(-3.222233331));
	    	
	    	Assertions.assertTrue(new BigDecimal(-2).compareTo(resta.execute())==0, "La resta de dos números negativos no es correcta.");	    		        	       
	    }
}

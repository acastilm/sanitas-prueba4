package com.sanitas.prueba4.model;

import java.math.BigDecimal;
import java.util.List;


public interface Operacion {
		
	public BigDecimal execute();
	
	public String getNombreOperacion();
	
	public List<BigDecimal> getOperandos();
}

package com.sanitas.prueba4.service;

import java.math.BigDecimal;

import com.sanitas.prueba4.model.ResultadoOperacion;

public interface OperacionesService {

	
	public ResultadoOperacion ejecutaOperacion(String operacion, BigDecimal [] operandos);
}

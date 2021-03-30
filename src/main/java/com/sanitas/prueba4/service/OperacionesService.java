package com.sanitas.prueba4.service;

import com.sanitas.prueba4.model.ResultadoOperacion;

public interface OperacionesService {

	
	public ResultadoOperacion ejecutaOperacion(String operacion, String [] operandos);
}

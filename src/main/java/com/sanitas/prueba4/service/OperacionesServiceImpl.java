package com.sanitas.prueba4.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.prueba4.model.Operacion;
import com.sanitas.prueba4.model.OperacionBuilder;
import com.sanitas.prueba4.model.ResultadoOperacion;

@Service
public class OperacionesServiceImpl implements OperacionesService {

	@Autowired
	OperacionBuilder opBuilder;
	
	@Override
	public ResultadoOperacion ejecutaOperacion(String nombreOperacion, BigDecimal[] operandos) {
		Operacion operacion = opBuilder.withOperacion(nombreOperacion)
				.setOperandos(operandos)
				.build();				
		return new ResultadoOperacion(operacion.execute());
	}	

	public void setOpBuilder(OperacionBuilder opBuilder) {
		this.opBuilder = opBuilder;
	}
	
	public OperacionBuilder getOpBuilder() {
		return opBuilder;
	}
}

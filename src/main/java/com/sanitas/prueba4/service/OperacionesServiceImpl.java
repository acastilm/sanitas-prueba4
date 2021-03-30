package com.sanitas.prueba4.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	public ResultadoOperacion ejecutaOperacion(String nombreOperacion, String[] operandos) {
		Operacion operacion = opBuilder.withOperacion(nombreOperacion)
				.setOperandos(convertToNumericValues(operandos))
				.build();				
		return new ResultadoOperacion(operacion.execute());
	}
	
	/**
	 * Convierte array de String en array de BigDecimal
	 * @param operandos
	 * @return
	 */
	private BigDecimal[] convertToNumericValues(String[] operandos) {				
		List<BigDecimal> valoresNumericos = Arrays.asList(operandos).stream().map(v -> new BigDecimal(v)).collect(Collectors.toList());		
		return valoresNumericos.toArray(new BigDecimal[valoresNumericos.size()]);
	}

	public void setOpBuilder(OperacionBuilder opBuilder) {
		this.opBuilder = opBuilder;
	}
	
	public OperacionBuilder getOpBuilder() {
		return opBuilder;
	}
}

package com.sanitas.prueba4.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OperacionResta implements Operacion {

	public static final String OP_NAME = "resta";
	private BigDecimal operando1;
	private BigDecimal operando2;

	public OperacionResta() {	
	}
	
	public OperacionResta(BigDecimal operando1, BigDecimal operando2) {
		if (operando1 == null) {
			throw new IllegalArgumentException("Operando 1 no especificado.");
		}
		if (operando2 == null) {
			throw new IllegalArgumentException("Operando 2 no especificado.");
		}
		this.operando1 = operando1;
		this.operando2 = operando2;
	}
	
	@Override
	public BigDecimal execute() {
				
		return operando1.subtract(operando2);
	}

	@Override
	public String getNombreOperacion() {
		return OP_NAME;
	}
	
	public List<BigDecimal> getOperandos() {
		return Arrays.asList(this.operando1, this.operando2);
	}
	
}

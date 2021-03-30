package com.sanitas.prueba4.model;

import java.math.BigDecimal;

public class ResultadoOperacion{

	private BigDecimal resultadoOperacion = BigDecimal.ZERO;
	private Operacion operacion;

	
	public ResultadoOperacion(BigDecimal valor) {
	
		this.resultadoOperacion = valor;
	}	
	
	public BigDecimal getResultadoOperacion() {
		return resultadoOperacion;
	}
	
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}
	
	public Operacion getOperacion() {
		return operacion;
	}
}

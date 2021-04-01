package com.sanitas.prueba4.model;

import java.math.BigDecimal;

public class ResultadoOperacion{

	private BigDecimal resultado = BigDecimal.ZERO;
	private Operacion operacion;

	public ResultadoOperacion() {	
		System.out.println("Constructor ResultadoOperacion");
	}
	
	public ResultadoOperacion(BigDecimal resultado) {
	
		this.resultado = resultado;
	}	
	
	public BigDecimal getResultado() {
		return resultado;
	}
	
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}
	
	public Operacion getOperacion() {
		return operacion;
	}
	
	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}
}

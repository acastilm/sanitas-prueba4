package com.sanitas.prueba4.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OperacionBuilder {

	public enum OPERACIONES {suma, resta}
	private List<BigDecimal> operandos = new ArrayList<BigDecimal>();
	private String nombreOperacion;
	
	public OperacionBuilder() {		
	}
	
	public OperacionBuilder withOperacion(String operacion) {		
		this.nombreOperacion = operacion;
		return this;
	}
	
	public OperacionBuilder addOperando(BigDecimal operando) {
		this.operandos.add(operando);
		return this;
	}
	
	public  OperacionBuilder setOperandos(BigDecimal [] operandos) {
		this.operandos = Arrays.asList(operandos);
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public Operacion build() {
		
		if (nombreOperacion.equals(OPERACIONES.suma.toString())){
			return buildOperacionSuma();
		}else if (nombreOperacion.equals(OPERACIONES.resta.toString())){			
			return buildOperacionResta();
		}else {
			throw new IllegalArgumentException("Operación '"+nombreOperacion+"' no implementada ");
		}		
	}
	
	private Operacion buildOperacionSuma() {		
		if (operandos.size()!=2) {
			throw new IllegalArgumentException("La operación suma usa 2 operandos, pero ha recibido "+operandos.size());
		}
		Operacion operacion = new OperacionSuma(operandos.get(0), operandos.get(1));		
		return operacion;
	}
	
	private Operacion buildOperacionResta() {
		if (operandos.size()!=2) {
			throw new IllegalArgumentException("La operación resta usa 2 operandos, pero ha recibido "+operandos.size());
		}
		Operacion operacion = new OperacionResta(operandos.get(0), operandos.get(1));				
		return operacion;
	}
}

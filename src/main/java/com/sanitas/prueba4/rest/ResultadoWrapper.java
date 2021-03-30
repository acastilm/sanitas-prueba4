package com.sanitas.prueba4.rest;

import java.math.BigDecimal;
import java.util.List;

import com.sanitas.prueba4.model.ResultadoOperacion;

public class ResultadoWrapper {

	public enum ESTADO {OK, KO};
		
	ResultadoOperacion resultado = new ResultadoOperacion(null);
	List<String> operandos;
	ESTADO estado;
	String msg;
	String nombreOperacion;
	
	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}
	
	public static ResultadoWrapper operacionExitosa(String operacion, List<String> operandos, ResultadoOperacion resultadoOp) {
		ResultadoWrapper resultado = new ResultadoWrapper();
		resultado.setEstado(ESTADO.OK);
		resultado.setMsg("Operación ejecutado con éxito");
		resultado.setNombreOperacion(operacion);
		resultado.setOperandos(operandos);
		resultado.setResultadoOperacion(resultadoOp);
		return resultado;
	}
	
	public static ResultadoWrapper operacionFallida(String operacion, List<String> operandos, String msgError) {
		ResultadoWrapper resultado = new ResultadoWrapper();
		resultado.setEstado(ESTADO.KO);
		resultado.setMsg(msgError);
		resultado.setNombreOperacion(operacion);
		resultado.setOperandos(operandos);
		return resultado;
		
	}
	
	public ESTADO getEstado() {
		return estado;
	}
	
	public void setResultadoOperacion(ResultadoOperacion resultado) {
		this.resultado = resultado;
	}
	
	public BigDecimal getValorResultado() {
		return resultado.getResultadoOperacion();
	}
	
	public String getNombreOperacion() {
		return nombreOperacion;
	}
	
	public void setOperandos(List<String> operandos) {
		this.operandos = operandos;
	}
	
	public List<String> getOperandos() {
		return operandos;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setNombreOperacion(String operacion) {

		this.nombreOperacion = operacion;
	}
	
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("'estado': '"+getEstado()).append("'")
			.append(", 'msg': '").append(getMsg()).append("'")
			.append(", 'nombreOperacion': '").append(nombreOperacion).append("'")
			.append(", 'operandos': ").append(getOperandos())
		    .append(", 'resultado':"+(resultado.getResultadoOperacion()!=null?resultado.getResultadoOperacion().toString():null));
		return strb.toString();
	}
	
}

package com.sanitas.prueba4.rest;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.prueba4.model.ResultadoOperacion;
import com.sanitas.prueba4.service.OperacionesService;

import io.corp.calculator.TracerImpl;

@RestController
public class OperacionAritmeticaController {

	
	@Autowired	
	OperacionesService operacionesService;
	

	TracerImpl tracer = new TracerImpl();
	
	@GetMapping("/v1/rest/calculadora")
	  @ResponseBody
	  public ResponseEntity<ResultadoWrapper> calcular(@RequestParam(name="operacion", required=true, defaultValue="") String operacion,
			  				@RequestParam(name="operandos", required=true, defaultValue="") BigDecimal[] operandos) {

		ResultadoWrapper resultado = null;
		try {
			ResultadoOperacion resultadoOperacion = operacionesService.ejecutaOperacion(operacion, operandos);					
			resultado =  ResultadoWrapper.operacionExitosa(operacion, Arrays.asList(operandos), resultadoOperacion.getResultado());
			tracer.trace(resultado);
			
		}catch (IllegalArgumentException iae) {
			resultado = ResultadoWrapper.operacionFallida(operacion, Arrays.asList(operandos), iae.getMessage());			
			tracer.trace(resultado);
			return new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
			
		}catch(Exception e) {
			resultado = ResultadoWrapper.operacionFallida(operacion, Arrays.asList(operandos), e.getMessage());			
			tracer.trace(resultado);
			return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<>(resultado, HttpStatus.OK);
	  }	
}

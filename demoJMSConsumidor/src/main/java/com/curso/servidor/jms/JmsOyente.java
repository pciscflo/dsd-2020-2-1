package com.curso.servidor.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.curso.servidor.entidades.Auto;
import com.curso.servidor.negocio.Negocio;

@Component
public class JmsOyente {
	
	@Autowired
	private Negocio negocio;
	
	@JmsListener(destination="${jms.queue.destination}")
	public void miMensaje(String mensajeJson) {
		System.out.println("Recibido:" + mensajeJson);
		//mensajeJSON a Objeto Auto
		ObjectMapper mapper = new ObjectMapper();
		try {
			//convirtiendo de JSON a Auto
			Auto auto =  mapper.readValue(mensajeJson, Auto.class);
			auto.setRespuesta("Registrar a Tabla");
			System.out.println(mensajeJson);
			Auto respuesta = negocio.grabar(auto);//registra en la base de  datos
			if (respuesta==null) {
				System.out.println("No se pudo registrar");
		    }	
			else {
				System.out.println("Registrado ok!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("No se pudo registrar");
		} 
	}
	
}
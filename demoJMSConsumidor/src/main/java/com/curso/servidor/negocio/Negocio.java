package com.curso.servidor.negocio;

import javax.transaction.Transactional;

import com.curso.servidor.repositorio.AutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.servidor.entidades.Auto;

@Service
public class Negocio {
	@Autowired
	private AutoRepositorio autoRepositorio;

	@Transactional
	public Auto grabar(Auto auto)
   {	   
	  return autoRepositorio.save(auto);
   }
}

package com.curso.servidor.repositorio;


import org.springframework.data.repository.CrudRepository;
import com.curso.servidor.entidades.Auto;


public interface AutoRepositorio extends CrudRepository<Auto, Long> {

}

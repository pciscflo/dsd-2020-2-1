package com.upc.tienda.repositorio;

import com.upc.tienda.entidades.Artefacto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//Agnostica
public interface ArtefactoRepositorio  extends CrudRepository<Artefacto, Long> {

}

package com.curso.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.curso.entidades.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Long> {

}

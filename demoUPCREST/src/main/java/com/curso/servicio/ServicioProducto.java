package com.curso.servicio;

import com.curso.entidades.Producto;

import java.util.List;

public interface ServicioProducto {
    List<Producto> obtenerProductos();

    Producto obtenerEntidad(Long codigo) throws Exception;

    Producto crearProducto(Producto producto);

    Producto actualizarProducto(Producto productoDetalle) throws Exception;

    Producto borrarProducto(Long codigo) throws Exception;
}

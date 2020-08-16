package com.curso.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entidades.Producto;
import com.curso.repositorio.ProductoRepositorio;

@Service
public class ServicioProductoImpl implements ServicioProducto {
    @Autowired
    public ProductoRepositorio productoRepositorio;


    @Override
    public List<Producto> obtenerProductos() {
        return (List<Producto>) productoRepositorio.findAll();
    }

    @Override
    public Producto obtenerEntidad(Long codigo) throws Exception {
        return productoRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontró entidad"));
    }


    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }


    @Override
    public Producto actualizarProducto(Producto productoDetalle) throws Exception {
        Producto producto = productoRepositorio.findById(productoDetalle.getCodigo()).orElseThrow(() -> new Exception("No se encontró entidad"));
        producto.setDescripcion(productoDetalle.getDescripcion());
        producto.setPrecio(productoDetalle.getPrecio());
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto borrarProducto(Long codigo) throws Exception {
        Producto producto = productoRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontró entidad"));
        productoRepositorio.delete(producto);
        return producto;
    }
}

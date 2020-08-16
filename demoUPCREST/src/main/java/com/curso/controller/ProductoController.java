package com.curso.controller;

import com.curso.entidades.Producto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ProductoController {
    @GetMapping("/productos")
    List<Producto> obtenerProductos();

    @PostMapping("/producto")
    Producto crearProducto(@Valid @RequestBody Producto producto);

    @PutMapping("/producto")
    Producto actualizarProducto(@Valid @RequestBody Producto productoDetalle);

    @DeleteMapping("/producto/{codigo}")
    Producto borrarProducto(@PathVariable(value = "codigo") Long codigo);

    @GetMapping("/entidad/{codigo}")
    Producto obtenerEntidad(@PathVariable(value = "codigo") Long codigo);
}

package com.curso.controller;

import java.util.List;

import javax.validation.Valid;

import com.curso.servicio.ServicioProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entidades.Producto;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ProductoControllerImpl implements ProductoController {
    @Autowired
    public ServicioProducto servicioProducto;

    Logger logger = LoggerFactory.getLogger(ProductoControllerImpl.class);

    @Override
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        return servicioProducto.obtenerProductos();
    }


    @Override
    @PostMapping("/producto")
    public Producto crearProducto(@Valid @RequestBody Producto producto) {
        Producto p;
        try {
            logger.debug("Creando objeto");
            p = servicioProducto.crearProducto(producto);
        } catch (Exception e) {
            logger.error("Error de creación", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo crear, sorry", e);
        }
        return p;
    }

    @Override
    @PutMapping("/producto")
    public Producto actualizarProducto(@Valid @RequestBody Producto productoDetalle) {
        Producto producto;
        try {
            logger.debug("Actualizando producto");
            producto = servicioProducto.actualizarProducto(productoDetalle);
            logger.debug("Producto Actualizado");
            return producto;
        } catch (Exception e) {
            logger.error("Error de Actualización ", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar, sorry");
        }
    }

    @Override
    @DeleteMapping("/producto/{codigo}")
    public Producto borrarProducto(@PathVariable(value = "codigo") Long codigo) {
        try {
            logger.debug("Eliminando objeto");
            return servicioProducto.borrarProducto(codigo);
        } catch (Exception e) {
            logger.error("Error de Eliminación ", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar, sorry");
        }
    }


    @Override
    @GetMapping("/entidad/{codigo}")
    public Producto obtenerEntidad(@PathVariable(value = "codigo") Long codigo) {
        Producto p;
        try {
            logger.debug("Buscando entidad");
            p = servicioProducto.obtenerEntidad(codigo);
        } catch (Exception e) {
            logger.error("Error de Obtener Entidad");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return p;
    }

}

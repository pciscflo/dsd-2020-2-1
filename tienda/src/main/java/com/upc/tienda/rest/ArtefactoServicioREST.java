package com.upc.tienda.rest;

import com.upc.tienda.entidades.Artefacto;
import com.upc.tienda.negocio.Negocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtefactoServicioREST {
    //inyectamos Negocio
    @Autowired
    private Negocio negocio;

    @GetMapping("/productos")
    public List<Artefacto> listarArtefactos(){
        return negocio.listarArtefactos();
    }
    @PostMapping("/producto")
    public Artefacto crearArtefacto(@RequestBody Artefacto artefacto){
        Artefacto a;
        try {
            a = negocio.crearArtefacto(artefacto);
        }catch(Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se pudo crear",e);
        }
        return a;
    }

    @GetMapping("/artefacto/descuento/{codigo}")
    public double obtenerDescuento(@PathVariable(value = "codigo") Long codigo){
        Artefacto a = new Artefacto();
        a.setCodigo(codigo);
        return negocio.calcularDescuento(a);
    }

}

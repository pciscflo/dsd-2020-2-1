package com.upc.tienda.negocio;

import com.upc.tienda.entidades.Artefacto;
import com.upc.tienda.repositorio.ArtefactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//No Agnostica==Orquestación
@Service
public class Negocio {
    //inyectando el repositorio
    @Autowired
    private ArtefactoRepositorio artefactoRepositorio;

    public List<Artefacto> listarArtefactos(){
        return (List<Artefacto>) artefactoRepositorio.findAll();
    }
    public double calcularIGV(Artefacto artefacto){
        Artefacto artefacto1 =  artefactoRepositorio.findById(artefacto.getCodigo()).get();
        return artefacto1.getPrecio()*0.18;
    }

    public double calcularDescuento(Artefacto artefacto){
        double descuento=0;
        Artefacto artefacto1 =  artefactoRepositorio.findById(artefacto.getCodigo()).get();
        if (artefacto1.getMarca().equals("PHILLIPS")){
            descuento = 0.10*artefacto1.getPrecio();
        }
        return  descuento;
    }
    public double calcularPrecioNeto(Artefacto artefacto){
        return artefacto.getPrecio() - calcularDescuento(artefacto);
    }

    public Artefacto crearArtefacto(Artefacto artefacto){
        return artefactoRepositorio.save(artefacto);
    }

}

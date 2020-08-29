package com.upc.relaciones.demo.serviciorest;

import com.upc.relaciones.demo.entidades.Cliente;
import com.upc.relaciones.demo.entidades.Pedido;
import com.upc.relaciones.demo.negocio.NegocioVentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicioRestVentas {
    @Autowired
    private NegocioVentas negocioVentas;
    @PostMapping("/cliente")
    public Cliente registrar(@RequestBody Cliente cliente){
        return negocioVentas.registrarCliente(cliente);
    }
    @GetMapping("/cliente/{dni}")
    public Cliente obtenerCliente(@PathVariable(value = "dni") String dni){
        return negocioVentas.obtenerCliente(dni);
    }

    @PostMapping("/pedido")
    public Pedido crearPedido(@RequestBody Pedido pedido){
        return negocioVentas.realizarPedido(pedido);
    }

    @GetMapping("/pedidos/{dni}")
    public List<Pedido> obtenerPedidos(@PathVariable(name = "dni") String dni){
        return negocioVentas.obtenerPedidosCliente(dni);
    }

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        return negocioVentas.obtenerClientes();
    }

    @GetMapping("/pedidos")
    public List<Pedido> obtenerPedidos(){
        return negocioVentas.obtenerPedidos();
    }

}

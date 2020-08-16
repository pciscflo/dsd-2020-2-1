package com.curso;

import com.curso.entidades.Producto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoUpcrestApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testInsertarEncuesta() {
        Producto producto = new Producto();
        producto.setDescripcion("Pollo a la brasa");
        producto.setPrecio(15.50);
        ResponseEntity<Producto> entidad = restTemplate.postForEntity("http://localhost:8080/api/producto", producto,
                Producto.class);
        assertNotNull(entidad);
    }

    //@Test
    public void testObtenerProductos() {
        Producto[] productos = restTemplate.getForObject("http://localhost:8080/api/productos", Producto[].class);
        List<Producto> productoss = Arrays.asList(productos);
        assertNotNull(productoss);
    }

    //@Test
    public void testBuscarProducto() {
        Producto producto = restTemplate.getForObject("http://localhost:8080/api/producto/1", Producto.class);
        assertNotNull(producto);
    }

    @Test
    public void actualizarProducto() {
        List<String> list = new ArrayList<>();
        list.add("Pepe");
        list.add("Pepsi");
        if (list.contains("Pepe")) {
            System.out.println("OK");
        }

    }

}

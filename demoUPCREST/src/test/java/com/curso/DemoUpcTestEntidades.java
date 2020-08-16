package com.curso;

import com.curso.entidades.Producto;
import com.curso.repositorio.ProductoRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@SpringBootTest
public class DemoUpcTestEntidades {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    //@Test
    public void contextLoads() {
    }

    @Test
    public void probarCrearEntidad() {
        Producto producto = new Producto();
        producto.setDescripcion("Chicle");
        producto.setPrecio(1.0);
        Producto p = productoRepositorio.save(producto);
        assertNotNull(p);
    }

    //@Test
    public void probarObtenerEntidad() {
        Producto producto = productoRepositorio.findById(1L).get();
        System.out.println(producto.getDescripcion());
        assertNotNull(producto);
    }

    //@Test
    public void probarObetenerEntidades() {
        Iterable<Producto> productos = productoRepositorio.findAll();
        for (Producto p : productos) {
            System.out.println(p.getDescripcion() + " " + p.getPrecio());
        }
        assertNotNull(productos);
    }

}
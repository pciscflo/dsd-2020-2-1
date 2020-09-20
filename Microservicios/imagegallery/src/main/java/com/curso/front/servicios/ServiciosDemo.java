package com.curso.front.servicios;

import com.curso.front.entidades.Galeria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class ServiciosDemo {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String home() {
        // Esto es útil para la depuración
        // Al tener múltiples instancias de servicio de galería ejecutándose en diferentes puertos.
        // Nosotros balanceamos la carga entre ellos y mostramos qué instancia recibió la solicitud.
        return "Hola de Galeria Service corriendo en el puerto: " + env.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Galeria getGallery(@PathVariable final int id) {
        // crea gallery object
        Galeria galeria = new Galeria();
        galeria.setId(id);

        // obtiene una lista de imágenes
        List<Object> imagenes = restTemplate.getForObject("http://image-service/images/", List.class);
        /*Al llamar a cualquier servicio desde el navegador, no podemos llamarlo por su nombre como lo hacemos aqui
         desde el servicio de getGallery:  esto se usa internamente entre los servicios. Entonces puedes usar Zuul
         para los navegadores
         */
        galeria.setImages(imagenes);

        return galeria;
    }

    // -------- Admin Area --------
    // Para usuarios de rol de administrador cuando se usa Spring Security
    @GetMapping("/admin")
    public String homeAdmin() {
        return "Este es administrador de area de Galeria service corriendo en el puerto: " + env.getProperty("local.server.port");
    }
}

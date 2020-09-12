package com.app.colas.ripley.rest;

import com.app.colas.ripley.entidades.Auto;
import com.app.colas.ripley.jms.JmsProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
public class ServicioRestJMS {
    @Autowired
    private JmsProducer jmsProducer;

    @PostMapping("/enviar")
    public Auto enviar(@RequestBody Auto auto){
        //convierto el Auto en formato JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(auto);
            jmsProducer.send(json);
        }catch(Exception e){
            auto.setRespuesta("Fallo no enviado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lo siento intentalo de nuevo");
        }
        return auto;
    }
}

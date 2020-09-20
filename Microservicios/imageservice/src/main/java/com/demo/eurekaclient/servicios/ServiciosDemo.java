package com.demo.eurekaclient.servicios;

import com.demo.eurekaclient.entidades.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class ServiciosDemo {
    @Autowired
    private Environment env;

    @GetMapping("/images")
    public List<Image> getImages() {
        System.out.println("Service Image:" + env.getProperty("local.server.port"));
        List<Image> images = Arrays.asList(
                new Image(1, "Th Witcher", "https://www.imdb.com/gallery/rg1859820288/mediaviewer/rm109682433"),
                new Image(2, "Tolkien", "https://www.imdb.com/gallery/rg1859820288/mediaviewer/rm268985856"),
                new Image(3, "Playmobil", "https://www.imdb.com/gallery/rg1859820288/mediaviewer/rm2625857024"));
        return images;
    }
}

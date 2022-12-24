package io.davi.film.resources;


import io.davi.film.dto.GenreDTO;
import io.davi.film.entities.Genre;
import io.davi.film.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {

    @Autowired
    private GenreService service;


    @GetMapping
    public ResponseEntity<List<GenreDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}

package io.davi.film.services;

import io.davi.film.dto.GenreDTO;
import io.davi.film.entities.Genre;
import io.davi.film.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public List<GenreDTO> findAll() {
        List<Genre> genries = repository.findAll();
        return genries.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
    }
}

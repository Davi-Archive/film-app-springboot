package io.davi.film.services;

import io.davi.film.dto.MovieDTO;
import io.davi.film.entities.Movie;
import io.davi.film.repositories.MovieRepository;
import io.davi.film.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public MovieDTO findById(Long id) {
        Optional<Movie> entity = repository.findById(id);
        MovieDTO dto = new MovieDTO(entity.orElseThrow(() -> new ResourceNotFoundException("Id not found")));
        return dto;
    }

    public Page<MovieDTO> findAllPaged(Long genreId, Pageable pageable) {
        if (genreId == 0) {
            genreId = null;
        }
        Pageable newPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("title")));
        Page<Movie> page = repository.find(genreId, newPageable);
        Page<MovieDTO> dto = page.map(x -> new MovieDTO(x));
        return dto;
    }

}

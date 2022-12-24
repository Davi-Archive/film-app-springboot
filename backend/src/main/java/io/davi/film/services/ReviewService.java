package io.davi.film.services;

import io.davi.film.dto.ReviewDTO;
import io.davi.film.entities.Movie;
import io.davi.film.entities.Review;
import io.davi.film.entities.User;
import io.davi.film.repositories.MovieRepository;
import io.davi.film.repositories.ReviewRepository;
import io.davi.film.repositories.UserRepository;
import io.davi.film.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public ReviewDTO insertReviewOnMovie(ReviewDTO dto) {
        Review entity = new Review();
        Optional<Movie> movie = movieRepository.findById(dto.getMovieId());
        Movie foundMovie = movie.orElseThrow(() -> new ResourceNotFoundException("Movie id not found"));
        entity.setMovie(foundMovie);

        copyDtoToEntity(dto, entity);
        repository.save(entity);

        return new ReviewDTO(entity);
    }

    public void copyDtoToEntity(ReviewDTO dto, Review entity) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username);
        entity.setUser(user);
        entity.setText(dto.getText());
    }
}

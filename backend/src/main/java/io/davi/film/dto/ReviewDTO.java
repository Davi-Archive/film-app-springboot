package io.davi.film.dto;

import io.davi.film.entities.Movie;
import io.davi.film.entities.Review;
import io.davi.film.entities.User;

public class ReviewDTO {
    private Long id;
    private String text;
    private Long movieId;
    private User user;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text, Long movieId, User user) {
        this.id = id;
        this.text = text;
        this.movieId = movieId;
        this.user = user;
    }

    public ReviewDTO(Review entity, Movie movie) {
        id = entity.getId();
        text = entity.getText();
        movieId = movie.getId();
        user = entity.getUser();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

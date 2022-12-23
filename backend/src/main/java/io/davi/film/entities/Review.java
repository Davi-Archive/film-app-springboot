package io.davi.film.entities;

import org.w3c.dom.Text;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_review")
public class Review implements Serializable {

    @Id
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Review() {
    }

    public Review(Long id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
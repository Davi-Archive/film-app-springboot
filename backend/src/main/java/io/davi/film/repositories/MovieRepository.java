package io.davi.film.repositories;

import io.davi.film.entities.Movie;
import io.davi.film.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}

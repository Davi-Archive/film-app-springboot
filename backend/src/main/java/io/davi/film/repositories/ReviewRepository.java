package io.davi.film.repositories;

import io.davi.film.entities.Movie;
import io.davi.film.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}

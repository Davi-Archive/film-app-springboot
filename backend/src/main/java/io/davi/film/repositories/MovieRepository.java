package io.davi.film.repositories;

import io.davi.film.entities.Movie;
import io.davi.film.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT obj FROM Movie obj WHERE "
            + "(:genreId is null or obj.genre.id = :genreId) "
            + "ORDER BY obj.title ASC")
    Page<Movie> find(Long genreId, Pageable pageable);
}

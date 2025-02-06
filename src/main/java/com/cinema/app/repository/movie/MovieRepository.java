package com.cinema.app.repository.movie;

import com.cinema.app.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);

    List<Movie> findByTitleContainingIgnoreCase(String title);
}

package com.cinema.app.repository.movie;

import com.cinema.app.model.movie.RegularMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegularMovieRepository extends JpaRepository<RegularMovie, Long> {
    List<RegularMovie> findByLanguage(String language);
}

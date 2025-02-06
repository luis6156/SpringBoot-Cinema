package com.cinema.app.repository.movie;

import com.cinema.app.model.movie.ImaxMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImaxMovieRepository extends JpaRepository<ImaxMovie, Long> {
    List<ImaxMovie> findByIs3D(boolean is3D);
}

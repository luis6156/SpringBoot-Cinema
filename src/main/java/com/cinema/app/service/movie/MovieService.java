package com.cinema.app.service.movie;

import com.cinema.app.model.movie.ImaxMovie;
import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.RegularMovie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie createMovie(Movie movie);

    Optional<Movie> getMovieById(Long id);

    List<Movie> getAllMovies();

    RegularMovie createRegularMovie(RegularMovie regularMovie);

    ImaxMovie createImaxMovie(ImaxMovie imaxMovie);

    List<RegularMovie> getAllRegularMovies();

    List<ImaxMovie> getAllImaxMovies();

    List<Movie> getMoviesByGenre(String genre);

    List<Movie> searchMoviesByTitle(String title);

    void deleteMovie(Long id);
}

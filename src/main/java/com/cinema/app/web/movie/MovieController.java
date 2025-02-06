package com.cinema.app.web.movie;

import com.cinema.app.model.movie.ImaxMovie;
import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.RegularMovie;
import com.cinema.app.service.movie.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieServiceImpl movieService;

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/{movieId}")
    public Optional<Movie> getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/regular")
    public RegularMovie createRegularMovie(@RequestBody RegularMovie regularMovie) {
        return movieService.createRegularMovie(regularMovie);
    }

    @PostMapping("/imax")
    public ImaxMovie createImaxMovie(@RequestBody ImaxMovie imaxMovie) {
        return movieService.createImaxMovie(imaxMovie);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("/regular")
    public List<RegularMovie> getAllRegularMovies() {
        return movieService.getAllRegularMovies();
    }

    @GetMapping("/imax")
    public List<ImaxMovie> getAllImaxMovies() {
        return movieService.getAllImaxMovies();
    }

    @GetMapping("/search/{title}")
    public List<Movie> searchMoviesByTitle(@PathVariable String title) {
        return movieService.searchMoviesByTitle(title);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}

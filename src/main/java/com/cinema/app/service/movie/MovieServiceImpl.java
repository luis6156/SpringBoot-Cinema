package com.cinema.app.service.movie;

import com.cinema.app.model.movie.ImaxMovie;
import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.RegularMovie;
import com.cinema.app.repository.movie.ImaxMovieRepository;
import com.cinema.app.repository.movie.MovieRepository;
import com.cinema.app.repository.movie.RegularMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final RegularMovieRepository regularMovieRepository;
    private final ImaxMovieRepository imaxMovieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public RegularMovie createRegularMovie(RegularMovie regularMovie) {
        return regularMovieRepository.save(regularMovie);
    }

    @Override
    public ImaxMovie createImaxMovie(ImaxMovie imaxMovie) {
        return imaxMovieRepository.save(imaxMovie);
    }

    @Override
    public List<RegularMovie> getAllRegularMovies() {
        return regularMovieRepository.findAll();
    }

    @Override
    public List<ImaxMovie> getAllImaxMovies() {
        return imaxMovieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

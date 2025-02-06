package com.cinema.app;

import com.cinema.app.model.movie.ImaxMovie;
import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.RegularMovie;
import com.cinema.app.repository.movie.ImaxMovieRepository;
import com.cinema.app.repository.movie.MovieRepository;
import com.cinema.app.repository.movie.RegularMovieRepository;
import com.cinema.app.service.movie.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private RegularMovieRepository regularMovieRepository;

    @Mock
    private ImaxMovieRepository imaxMovieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    private Movie movie;
    private RegularMovie regularMovie;
    private ImaxMovie imaxMovie;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Test Movie");

        regularMovie = new RegularMovie();
        regularMovie.setId(2L);
        regularMovie.setTitle("Test Regular Movie");

        imaxMovie = new ImaxMovie();
        imaxMovie.setId(3L);
        imaxMovie.setTitle("Test Imax Movie");
    }

    @Test
    public void testCreateMovie() {
        when(movieRepository.save(movie)).thenReturn(movie);

        Movie createdMovie = movieService.createMovie(movie);

        assertNotNull(createdMovie);
        assertEquals(movie.getId(), createdMovie.getId());
    }

    @Test
    public void testGetMovieById() {
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        Optional<Movie> foundMovie = movieService.getMovieById(1L);

        assertTrue(foundMovie.isPresent());
        assertEquals(movie.getId(), foundMovie.get().getId());
    }

    @Test
    public void testGetAllMovies() {
        List<Movie> movies = Arrays.asList(movie, regularMovie, imaxMovie);
        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> allMovies = movieService.getAllMovies();

        assertNotNull(allMovies);
        assertEquals(3, allMovies.size());
    }

    @Test
    public void testCreateRegularMovie() {
        when(regularMovieRepository.save(regularMovie)).thenReturn(regularMovie);

        RegularMovie createdRegularMovie = movieService.createRegularMovie(regularMovie);

        assertNotNull(createdRegularMovie);
        assertEquals(regularMovie.getId(), createdRegularMovie.getId());
    }

    @Test
    public void testCreateImaxMovie() {
        when(imaxMovieRepository.save(imaxMovie)).thenReturn(imaxMovie);

        ImaxMovie createdImaxMovie = movieService.createImaxMovie(imaxMovie);

        assertNotNull(createdImaxMovie);
        assertEquals(imaxMovie.getId(), createdImaxMovie.getId());
    }

    @Test
    public void testGetAllRegularMovies() {
        when(regularMovieRepository.findAll()).thenReturn(Collections.singletonList(regularMovie));

        List<RegularMovie> allRegularMovies = movieService.getAllRegularMovies();

        assertNotNull(allRegularMovies);
        assertEquals(1, allRegularMovies.size());
    }

    @Test
    public void testGetAllImaxMovies() {
        when(imaxMovieRepository.findAll()).thenReturn(Collections.singletonList(imaxMovie));

        List<ImaxMovie> allImaxMovies = movieService.getAllImaxMovies();

        assertNotNull(allImaxMovies);
        assertEquals(1, allImaxMovies.size());
    }

    @Test
    public void testGetMoviesByGenre() {
        when(movieRepository.findByGenre("Action")).thenReturn(Collections.singletonList(movie));

        List<Movie> moviesByGenre = movieService.getMoviesByGenre("Action");

        assertNotNull(moviesByGenre);
        assertEquals(1, moviesByGenre.size());
        assertEquals("Test Movie", moviesByGenre.getFirst().getTitle());
    }

    @Test
    public void testSearchMoviesByTitle() {
        when(movieRepository.findByTitleContainingIgnoreCase("test")).thenReturn(Arrays.asList(movie, regularMovie, imaxMovie));

        List<Movie> searchedMovies = movieService.searchMoviesByTitle("test");

        assertNotNull(searchedMovies);
        assertEquals(3, searchedMovies.size());
    }

    @Test
    public void testDeleteMovie() {
        doNothing().when(movieRepository).deleteById(1L);

        movieService.deleteMovie(1L);

        verify(movieRepository, times(1)).deleteById(1L);
    }
}


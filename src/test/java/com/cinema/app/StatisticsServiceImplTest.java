package com.cinema.app;

import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.MovieStatisticsReport;
import com.cinema.app.repository.movie.MovieRepository;
import com.cinema.app.repository.ticket.TicketRepository;
import com.cinema.app.service.StatisticsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private StatisticsServiceImpl statisticsService;

    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks

        // Create test data for movies
        movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("Movie 1");

        movie2 = new Movie();
        movie2.setId(2L);
        movie2.setTitle("Movie 2");
    }

    @Test
    public void testGetTopMoviesByRevenueAsync() throws Exception {
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));
        when(ticketRepository.getTotalRevenueForMovie(movie1)).thenReturn(100.0f);
        when(ticketRepository.getTotalRevenueForMovie(movie2)).thenReturn(200.0f);

        CompletableFuture<List<Movie>> topMoviesFuture = statisticsService.getTopMoviesByRevenueAsync(2L);
        List<Movie> topMovies = topMoviesFuture.get(); // Since it's async, we use get() to block and retrieve the result

        assertNotNull(topMovies);
        assertEquals(2, topMovies.size());
        assertEquals(movie2.getTitle(), topMovies.get(0).getTitle()); // Movie 2 should come first as it has higher revenue
    }

    @Test
    public void testGetTopMoviesByTicketsSoldAsync() throws Exception {
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));
        when(ticketRepository.countByShowtime_Movie(movie1)).thenReturn(50L);
        when(ticketRepository.countByShowtime_Movie(movie2)).thenReturn(100L);

        CompletableFuture<List<Movie>> topMoviesFuture = statisticsService.getTopMoviesByTicketsSoldAsync(2L);
        List<Movie> topMovies = topMoviesFuture.get();

        assertNotNull(topMovies);
        assertEquals(2, topMovies.size());
        assertEquals(movie2.getTitle(), topMovies.get(0).getTitle()); // Movie 2 should come first as it has more tickets sold
    }

    @Test
    public void testGetCompleteReport() throws Exception {
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));
        when(ticketRepository.getTotalRevenueForMovie(movie1)).thenReturn(100.0f);
        when(ticketRepository.getTotalRevenueForMovie(movie2)).thenReturn(200.0f);
        when(ticketRepository.countByShowtime_Movie(movie1)).thenReturn(50L);
        when(ticketRepository.countByShowtime_Movie(movie2)).thenReturn(100L);

        CompletableFuture<MovieStatisticsReport> reportFuture = statisticsService.getCompleteReport(2L);
        MovieStatisticsReport report = reportFuture.get();

        assertNotNull(report);
    }
}


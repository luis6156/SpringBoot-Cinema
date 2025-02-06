package com.cinema.app.service;

import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.MovieStatisticsReport;
import com.cinema.app.repository.movie.MovieRepository;
import com.cinema.app.repository.ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private final TicketRepository ticketRepository;
    private final MovieRepository movieRepository;

    @Async
    public CompletableFuture<List<Movie>> getTopMoviesByRevenueAsync(Long topCount) {
        List<Movie> topMovies = movieRepository.findAll().stream()
                .peek(movie -> {
                    // Get the total revenue for each movie
                    Float revenue = ticketRepository.getTotalRevenueForMovie(movie);
                    movie.setRevenue(revenue);  // Add a custom property for sorting
                })
                .sorted((m1, m2) -> Float.compare(m2.getRevenue(), m1.getRevenue()))
                .limit(topCount)
                .toList();

        return CompletableFuture.completedFuture(topMovies);
    }

    @Async
    public CompletableFuture<List<Movie>> getTopMoviesByTicketsSoldAsync(Long topCount) {
        List<Movie> topMovies = movieRepository.findAll().stream()
                .peek(movie -> {
                    // Count the number of tickets sold for each movie
                    long soldTickets = ticketRepository.countByShowtime_Movie(movie);
                    movie.setSoldTickets(soldTickets);  // Add a custom property for sorting
                })
                .sorted((m1, m2) -> Long.compare(m2.getSoldTickets(), m1.getSoldTickets()))
                .limit(topCount)
                .toList();

        return CompletableFuture.completedFuture(topMovies);
    }

    @Async
    public CompletableFuture<MovieStatisticsReport> getCompleteReport(Long topCount) {
        CompletableFuture<List<Movie>> topMoviesByRevenueFuture = getTopMoviesByRevenueAsync(topCount);
        CompletableFuture<List<Movie>> topMoviesByTicketsSoldFuture = getTopMoviesByTicketsSoldAsync(topCount);

        // Combine the top movies by revenue and tickets sold into a report
        return topMoviesByRevenueFuture.thenCombine(topMoviesByTicketsSoldFuture, MovieStatisticsReport::new);
    }
}

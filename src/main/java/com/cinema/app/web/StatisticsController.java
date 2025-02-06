package com.cinema.app.web;

import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.MovieStatisticsReport;
import com.cinema.app.service.StatisticsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsServiceImpl statisticsService;

    @GetMapping("/topMovies/tickets-sold/{topCount}")
    public CompletableFuture<ResponseEntity<List<Movie>>> generateTicketSalesStats(@PathVariable Long topCount) {
        return statisticsService.getTopMoviesByTicketsSoldAsync(topCount).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/topMovies/tickets/{topCount}")
    public CompletableFuture<ResponseEntity<List<Movie>>> getTopMoviesByRevenue(@PathVariable Long topCount) {
        return statisticsService.getTopMoviesByRevenueAsync(topCount).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/topMovies/all/{topCount}")
    public CompletableFuture<ResponseEntity<MovieStatisticsReport>> getCompleteReport(@PathVariable Long topCount) {
        return statisticsService.getCompleteReport(topCount).thenApply(ResponseEntity::ok);
    }
}

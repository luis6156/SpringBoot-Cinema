package com.cinema.app.service;

import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.movie.MovieStatisticsReport;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface StatisticsService {
    CompletableFuture<List<Movie>> getTopMoviesByRevenueAsync(Long topCount);

    CompletableFuture<List<Movie>> getTopMoviesByTicketsSoldAsync(Long topCount);

    CompletableFuture<MovieStatisticsReport> getCompleteReport(Long topCount);
}

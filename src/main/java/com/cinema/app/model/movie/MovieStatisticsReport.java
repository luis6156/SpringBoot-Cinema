package com.cinema.app.model.movie;

import java.util.List;

public record MovieStatisticsReport(List<Movie> topMoviesByRevenue, List<Movie> topMoviesByTicketsSold) { }

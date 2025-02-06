package com.cinema.app.service;

import com.cinema.app.model.Showtime;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShowtimeService {
    Showtime createShowtime(Showtime showtime);

    List<Showtime> getShowtimesByMovie(Long movieId);

    List<Showtime> getShowtimesInTimeRange(LocalDateTime start, LocalDateTime end);

    Optional<Showtime> getShowtimeById(Long showtimeId);

    Showtime updateShowtime(Long showtimeId, Showtime showtime);

    void deleteShowtime(Long showtimeId);
}

package com.cinema.app.web;

import com.cinema.app.model.Showtime;
import com.cinema.app.service.ShowtimeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {
    private final ShowtimeServiceImpl showtimeService;

    @PostMapping
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeService.createShowtime(showtime);
    }

    @GetMapping("/movie/{movieId}")
    public List<Showtime> getShowtimesByMovie(@PathVariable Long movieId) {
        return showtimeService.getShowtimesByMovie(movieId);
    }

    @GetMapping("/range")
    public List<Showtime> getShowtimesInTimeRange(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return showtimeService.getShowtimesInTimeRange(start, end);
    }

    @GetMapping("/{showtimeId}")
    public Optional<Showtime> getShowtimeById(@PathVariable Long showtimeId) {
        return showtimeService.getShowtimeById(showtimeId);
    }

    @PutMapping("/{showtimeId}")
    public Showtime updateShowtime(@PathVariable Long showtimeId, @RequestBody Showtime showtime) {
        return showtimeService.updateShowtime(showtimeId, showtime);
    }

    @DeleteMapping("/{showtimeId}")
    public void deleteShowtime(@PathVariable Long showtimeId) {
        showtimeService.deleteShowtime(showtimeId);
    }
}
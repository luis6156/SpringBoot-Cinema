package com.cinema.app.service;

import com.cinema.app.model.Showtime;
import com.cinema.app.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {
    private final ShowtimeRepository showtimeRepository;

    @Override
    public Showtime createShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public List<Showtime> getShowtimesByMovie(Long movieId) {
        return showtimeRepository.findByMovie_Id(movieId);
    }

    @Override
    public List<Showtime> getShowtimesInTimeRange(LocalDateTime start, LocalDateTime end) {
        return showtimeRepository.findByStartTimeBetween(start, end);
    }

    @Override
    public Optional<Showtime> getShowtimeById(Long showtimeId) {
        return showtimeRepository.findById(showtimeId);
    }

    @Override
    public Showtime updateShowtime(Long showtimeId, Showtime showtime) {
        if (showtimeRepository.existsById(showtimeId)) {
            showtime.setId(showtimeId);
            return showtimeRepository.save(showtime);
        }
        return null;
    }

    @Override
    public void deleteShowtime(Long showtimeId) {
        showtimeRepository.deleteById(showtimeId);
    }
}

package com.cinema.app.repository;

import com.cinema.app.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovie_Id(Long movieId);

    List<Showtime> findByStartTimeBetween(LocalDateTime startTimeAfter, LocalDateTime startTimeBefore);
}

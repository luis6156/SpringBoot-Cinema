package com.cinema.app.model;

import com.cinema.app.model.movie.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Showtime extends BaseEntity {
    @ManyToOne
    private Movie movie;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Screen screen;
}

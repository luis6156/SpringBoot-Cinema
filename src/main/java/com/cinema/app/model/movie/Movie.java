package com.cinema.app.model.movie;

import com.cinema.app.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Movie extends BaseEntity {
    private String title;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;

    private Float revenue;
    private Long soldTickets;
}

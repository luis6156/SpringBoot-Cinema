package com.cinema.app.model;

import com.cinema.app.model.movie.Movie;
import com.cinema.app.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review extends BaseEntity {
    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

    private Integer rating;
    private String comment;
}

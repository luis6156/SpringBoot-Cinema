package com.cinema.app.model.ticket;

import com.cinema.app.model.BaseEntity;
import com.cinema.app.model.Showtime;
import com.cinema.app.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Ticket extends BaseEntity {
    @ManyToOne
    private Showtime showtime;

    @ManyToOne
    private User user;

    private Float price;
    private String seatNumber;
}

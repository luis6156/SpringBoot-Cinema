package com.cinema.app.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen extends BaseEntity {
    private Integer screenNumber;
    private Integer seatCapacity;
}

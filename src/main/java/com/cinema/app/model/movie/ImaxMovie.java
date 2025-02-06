package com.cinema.app.model.movie;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ImaxMovie extends Movie {
    private boolean is3D;
}

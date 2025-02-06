package com.cinema.app.service.movie;

import com.cinema.app.model.movie.RegularMovie;

import java.util.List;

public interface RegularMovieService {
    List<RegularMovie> getMoviesByLanguage(String language);
}

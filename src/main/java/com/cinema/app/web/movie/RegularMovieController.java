package com.cinema.app.web.movie;

import com.cinema.app.model.movie.RegularMovie;
import com.cinema.app.service.movie.RegularMovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regular-movies")
@RequiredArgsConstructor
public class RegularMovieController {
    private final RegularMovieServiceImpl regularMovieService;

    @GetMapping("/language/{language}")
    public List<RegularMovie> getMoviesByLanguage(@PathVariable String language) {
        return regularMovieService.getMoviesByLanguage(language);
    }
}

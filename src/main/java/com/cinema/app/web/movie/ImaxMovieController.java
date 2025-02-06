package com.cinema.app.web.movie;

import com.cinema.app.model.movie.ImaxMovie;
import com.cinema.app.service.movie.ImaxMovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/imax-movies")
@RequiredArgsConstructor
public class ImaxMovieController {
    private final ImaxMovieServiceImpl imaxMovieService;

    @GetMapping("/3d")
    public List<ImaxMovie> get3DMovies() {
        return imaxMovieService.get3DMovies();
    }
}

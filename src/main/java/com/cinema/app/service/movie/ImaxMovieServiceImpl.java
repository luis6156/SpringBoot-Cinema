package com.cinema.app.service.movie;

import com.cinema.app.model.movie.ImaxMovie;
import com.cinema.app.repository.movie.ImaxMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImaxMovieServiceImpl implements ImaxMovieService {
    private final ImaxMovieRepository imaxMovieRepository;

    @Override
    public List<ImaxMovie> get3DMovies() {
        return imaxMovieRepository.findByIs3D(true);
    }
}

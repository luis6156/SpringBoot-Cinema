package com.cinema.app.service.movie;

import com.cinema.app.model.movie.RegularMovie;
import com.cinema.app.repository.movie.RegularMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegularMovieServiceImpl implements RegularMovieService {
    private final RegularMovieRepository regularMovieRepository;

    @Override
    public List<RegularMovie> getMoviesByLanguage(String language) {
        return regularMovieRepository.findByLanguage(language);
    }
}

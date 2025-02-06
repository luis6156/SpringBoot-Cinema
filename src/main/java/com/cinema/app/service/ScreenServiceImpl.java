package com.cinema.app.service;

import com.cinema.app.model.Screen;
import com.cinema.app.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {
    private final ScreenRepository screenRepository;

    @Override
    public Screen createScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    @Override
    public Optional<Screen> getScreenById(Long screenId) {
        return screenRepository.findById(screenId);
    }

    @Override
    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    @Override
    public Screen updateScreen(Long screenId, Screen screen) {
        if (screenRepository.existsById(screenId)) {
            screen.setId(screenId);
            return screenRepository.save(screen);
        }
        return null;
    }

    @Override
    public Optional<Screen> getScreenByNumber(Integer screenNumber) {
        return Optional.ofNullable(screenRepository.findByScreenNumber(screenNumber).getFirst());
    }

    @Override
    public void deleteScreen(Long screenId) {
        screenRepository.deleteById(screenId);
    }
}

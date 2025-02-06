package com.cinema.app.service;

import com.cinema.app.model.Screen;

import java.util.List;
import java.util.Optional;

public interface ScreenService {
    Screen createScreen(Screen screen);

    Optional<Screen> getScreenById(Long screenId);

    List<Screen> getAllScreens();

    Screen updateScreen(Long screenId, Screen screen);

    Optional<Screen> getScreenByNumber(Integer screenNumber);

    void deleteScreen(Long screenId);
}

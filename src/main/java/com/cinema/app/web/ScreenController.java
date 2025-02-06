package com.cinema.app.web;

import com.cinema.app.model.Screen;
import com.cinema.app.service.ScreenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenServiceImpl screenService;

    @GetMapping("/number/{screenNumber}")
    public Optional<Screen> getScreenByNumber(@PathVariable Integer screenNumber) {
        return screenService.getScreenByNumber(screenNumber);
    }
}

package com.cinema.app;

import com.cinema.app.model.Screen;
import com.cinema.app.repository.ScreenRepository;
import com.cinema.app.service.ScreenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ScreenServiceImplTest {

    @Mock
    private ScreenRepository screenRepository;

    @InjectMocks
    private ScreenServiceImpl screenService;

    private Screen screen;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks

        // Create test data
        screen = new Screen();
        screen.setId(1L);
        screen.setScreenNumber(1);
    }

    @Test
    public void testCreateScreen() {
        when(screenRepository.save(screen)).thenReturn(screen);

        Screen createdScreen = screenService.createScreen(screen);

        assertNotNull(createdScreen);
        assertEquals(screen.getId(), createdScreen.getId());
    }

    @Test
    public void testGetScreenById() {
        when(screenRepository.findById(1L)).thenReturn(Optional.of(screen));

        Optional<Screen> foundScreen = screenService.getScreenById(1L);

        assertTrue(foundScreen.isPresent());
        assertEquals(screen.getId(), foundScreen.get().getId());
    }

    @Test
    public void testGetAllScreens() {
        when(screenRepository.findAll()).thenReturn(Collections.singletonList(screen));

        List<Screen> screens = screenService.getAllScreens();

        assertNotNull(screens);
        assertEquals(1, screens.size());
        assertEquals(screen.getId(), screens.getFirst().getId());
    }

    @Test
    public void testUpdateScreen() {
        when(screenRepository.existsById(1L)).thenReturn(true);
        when(screenRepository.save(screen)).thenReturn(screen);

        Screen updatedScreen = screenService.updateScreen(1L, screen);

        assertNotNull(updatedScreen);
        assertEquals(screen.getId(), updatedScreen.getId());
    }

    @Test
    public void testUpdateScreenNotFound() {
        when(screenRepository.existsById(1L)).thenReturn(false);

        Screen updatedScreen = screenService.updateScreen(1L, screen);

        assertNull(updatedScreen);
    }

    @Test
    public void testGetScreenByNumber() {
        when(screenRepository.findByScreenNumber(1)).thenReturn(List.of(screen));

        Optional<Screen> foundScreen = screenService.getScreenByNumber(1);

        assertTrue(foundScreen.isPresent());
        assertEquals(screen.getScreenNumber(), foundScreen.get().getScreenNumber());
    }

    @Test
    public void testDeleteScreen() {
        doNothing().when(screenRepository).deleteById(1L);

        screenService.deleteScreen(1L);

        verify(screenRepository, times(1)).deleteById(1L);
    }
}


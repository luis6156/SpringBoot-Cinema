package com.cinema.app;

import com.cinema.app.model.Showtime;
import com.cinema.app.repository.ShowtimeRepository;
import com.cinema.app.service.ShowtimeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShowtimeServiceImplTest {

    @Mock
    private ShowtimeRepository showtimeRepository;

    @InjectMocks
    private ShowtimeServiceImpl showtimeService;

    private Showtime showtime;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks

        // Create test data
        showtime = new Showtime();
        showtime.setId(1L);
        showtime.setStartTime(LocalDateTime.now());
    }

    @Test
    public void testCreateShowtime() {
        when(showtimeRepository.save(showtime)).thenReturn(showtime);

        Showtime createdShowtime = showtimeService.createShowtime(showtime);

        assertNotNull(createdShowtime);
        assertEquals(showtime.getId(), createdShowtime.getId());
    }

    @Test
    public void testGetShowtimesByMovie() {
        when(showtimeRepository.findByMovie_Id(1L)).thenReturn(Collections.singletonList(showtime));

        List<Showtime> showtimes = showtimeService.getShowtimesByMovie(1L);

        assertNotNull(showtimes);
        assertEquals(1, showtimes.size());
    }

    @Test
    public void testGetShowtimesInTimeRange() {
        LocalDateTime start = LocalDateTime.now().minusHours(1);
        LocalDateTime end = LocalDateTime.now().plusHours(1);

        when(showtimeRepository.findByStartTimeBetween(start, end)).thenReturn(Collections.singletonList(showtime));

        List<Showtime> showtimes = showtimeService.getShowtimesInTimeRange(start, end);

        assertNotNull(showtimes);
        assertEquals(1, showtimes.size());
        assertTrue(showtimes.getFirst().getStartTime().isAfter(start) && showtimes.getFirst().getStartTime().isBefore(end));
    }

    @Test
    public void testGetShowtimeById() {
        when(showtimeRepository.findById(1L)).thenReturn(Optional.of(showtime));

        Optional<Showtime> foundShowtime = showtimeService.getShowtimeById(1L);

        assertTrue(foundShowtime.isPresent());
        assertEquals(showtime.getId(), foundShowtime.get().getId());
    }

    @Test
    public void testUpdateShowtime() {
        when(showtimeRepository.existsById(1L)).thenReturn(true);
        when(showtimeRepository.save(showtime)).thenReturn(showtime);

        Showtime updatedShowtime = showtimeService.updateShowtime(1L, showtime);

        assertNotNull(updatedShowtime);
        assertEquals(showtime.getId(), updatedShowtime.getId());
    }

    @Test
    public void testUpdateShowtimeNotFound() {
        when(showtimeRepository.existsById(1L)).thenReturn(false);

        Showtime updatedShowtime = showtimeService.updateShowtime(1L, showtime);

        assertNull(updatedShowtime);
    }

    @Test
    public void testDeleteShowtime() {
        doNothing().when(showtimeRepository).deleteById(1L);

        showtimeService.deleteShowtime(1L);

        verify(showtimeRepository, times(1)).deleteById(1L);
    }
}


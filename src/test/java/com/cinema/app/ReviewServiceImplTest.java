package com.cinema.app;

import com.cinema.app.model.Review;
import com.cinema.app.repository.ReviewRepository;
import com.cinema.app.service.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    private Review review;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks

        review = new Review();
        review.setId(1L);
        review.setRating(4);
        review.setComment("Great movie!");
    }

    @Test
    public void testCreateReview() {
        when(reviewRepository.save(review)).thenReturn(review);

        Review createdReview = reviewService.createReview(review);

        assertNotNull(createdReview);
        assertEquals(review.getId(), createdReview.getId());
        assertEquals(review.getRating(), createdReview.getRating());
    }

    @Test
    public void testGetReviewsByMovie() {
        when(reviewRepository.findByMovie_Id(1L)).thenReturn(Collections.singletonList(review));

        List<Review> reviews = reviewService.getReviewsByMovie(1L);

        assertNotNull(reviews);
        assertEquals(1, reviews.size());
        assertEquals(review.getId(), reviews.getFirst().getId());
    }

    @Test
    public void testGetReviewsWithRatingAbove() {
        when(reviewRepository.findByRatingGreaterThanEqual(4)).thenReturn(Collections.singletonList(review));

        List<Review> reviews = reviewService.getReviewsWithRatingAbove(4);

        assertNotNull(reviews);
        assertEquals(1, reviews.size());
        assertTrue(reviews.getFirst().getRating() >= 4);
    }

    @Test
    public void testGetReviewById() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

        Optional<Review> foundReview = reviewService.getReviewById(1L);

        assertTrue(foundReview.isPresent());
        assertEquals(review.getId(), foundReview.get().getId());
    }

    @Test
    public void testDeleteReview() {
        doNothing().when(reviewRepository).deleteById(1L);

        reviewService.deleteReview(1L);

        verify(reviewRepository, times(1)).deleteById(1L);
    }
}


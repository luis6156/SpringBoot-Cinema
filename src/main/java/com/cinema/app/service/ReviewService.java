package com.cinema.app.service;

import com.cinema.app.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review createReview(Review review);

    List<Review> getReviewsByMovie(Long movieId);

    List<Review> getReviewsWithRatingAbove(Integer rating);

    Optional<Review> getReviewById(Long reviewId);

    void deleteReview(Long reviewId);
}

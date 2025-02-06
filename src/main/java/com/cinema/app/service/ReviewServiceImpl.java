package com.cinema.app.service;

import com.cinema.app.model.Review;
import com.cinema.app.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovie_Id(movieId);
    }

    @Override
    public List<Review> getReviewsWithRatingAbove(Integer rating) {
        return reviewRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}

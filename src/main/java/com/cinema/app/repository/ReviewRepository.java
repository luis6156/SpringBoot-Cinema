package com.cinema.app.repository;

import com.cinema.app.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovie_Id(Long movieId);

    List<Review> findByRatingGreaterThanEqual(Integer ratingIsGreaterThan);
}

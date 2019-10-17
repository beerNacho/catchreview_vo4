package com.catchreview.review.persistence;

import org.springframework.data.repository.CrudRepository;

import com.catchreview.review.domain.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{

}

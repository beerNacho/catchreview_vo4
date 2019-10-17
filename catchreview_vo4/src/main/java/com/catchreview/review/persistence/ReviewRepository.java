package com.catchreview.review.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.catchreview.review.domain.QReview;
import com.catchreview.review.domain.Review;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface ReviewRepository extends CrudRepository<Review, Long>, QuerydslPredicateExecutor<Review>{
	
	public default Predicate makePredicate(Long storeNum) {
		
		BooleanBuilder builder = new BooleanBuilder();

		QReview review = QReview.review;

		builder.and(review.store.storeNum.gt(0));

		if (storeNum == null) {
			System.out.println("id : null");
			return builder;
		} else {
			System.out.println("store id : " + review.store.storeNum);
			builder.and(review.store.storeNum.eq(storeNum));
		}

		return builder;
	}
}

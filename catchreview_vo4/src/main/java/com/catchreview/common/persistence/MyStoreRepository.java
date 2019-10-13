package com.catchreview.common.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.catchreview.store.domain.QStore;
import com.catchreview.store.domain.Store;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface MyStoreRepository extends CrudRepository<Store, Long>, QuerydslPredicateExecutor<Store> {

	public default Predicate makePredicate(Long id) {
		BooleanBuilder builder = new BooleanBuilder();

		QStore store = QStore.store;

		builder.and(store.storeNum.gt(0));

		if (id == null) {
			System.out.println("id : null");
			return builder;
		} else {
			System.out.println("store id : " + store.user.id);
			builder.and(store.user.id.eq(id));
		}

		return builder;
	}
}

package com.catchreview.common.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.catchreview.store.domain.Store;

public interface MypageStoreRepository extends JpaRepository<Store, Long>, QuerydslPredicateExecutor<Store>{

}

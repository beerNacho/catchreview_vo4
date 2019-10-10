package com.catchreview.common.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchreview.store.domain.Store;

public interface MypageCustomCrudRepository extends JpaRepository<Store, Long>, CustomMypage{
	

}

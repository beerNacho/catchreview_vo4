package com.catchreview.store.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.catchreview.join.domain.Member;
import com.catchreview.store.domain.Store;

public interface StoreRepository extends CrudRepository<Store, Long>{
	@Query("SELECT s FROM Store s WHERE s.user = ?1")
	public List<Store> getStoresOfId(Member user);
}

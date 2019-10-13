package com.catchreview.reward.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.catchreview.reward.domain.Reward;
import com.catchreview.store.domain.Store;

public interface RewardRepository extends CrudRepository<Reward, Long>{

	Optional<Reward> findByStore(Store store);
}

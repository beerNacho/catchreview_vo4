package com.catchreview;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.catchreview.common.persistence.MyStoreRepository;
import com.catchreview.join.domain.Member;
import com.catchreview.store.domain.Store;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
@Log
public class MyStoreTests {

	@Autowired
	private MyStoreRepository storeRepo;
	

	public void insertStoreDummies() {
		
		IntStream.range(0, 20).forEach(i -> {
			
			Store store = new Store();
			
			store.setStoreName("Sample store " + i);
			store.setStoreAddress1("서울 서초구");
			store.setStoreAddress2("양재 2동" + i);
			
			System.out.println(store.getStoreName());
			System.out.println(store.getStoreAddress1());
			System.out.println(store.getStoreAddress2());
			
			Member member = new Member();
			member.setId(98L);
			
			store.setUser(member);
			
			storeRepo.save(store);
		});
	}
	
	@Test
	public void testList1() {
		
		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "storeNum");
		
		Page<Store> result = storeRepo.findAll(
				storeRepo.makePredicate(98L), pageable);
		
		log.info("PAGE : " + result.getPageable());
		
		result.getContent().forEach(store -> log.info("" + store));
		
	}
	
	
//	@Test
//	public void testList1() {
//		
//		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "storeNum");
//		
//		Page<Store> result = storeRepo.findAll(
//				storeRepo.makePredicate(99L), pageable);
//		
//		log.info("Page : " + result.getPageable());
//		
//		result.getContent().forEach(store -> log.info("" + store));
//		
//	}
	
	
	
}

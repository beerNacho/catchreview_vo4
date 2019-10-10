package com.catchreview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.catchreview.join.domain.Member;
import com.catchreview.join.persistence.MemberRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTests {

	@Autowired
	private MemberRepository repo;
	
	@Test
	public void testInsert() {
		
		for(int i=0; i<=100; i++) {
			Member member = new Member();
			member.setUemail("user" + i);
			member.setUpw("pw" + i);
			member.setUname("사용자" + i);
			
			repo.save(member);
		}
	}
	
	public void testRead() {
		
//		Optional<Member> result = repo.findById("user85");
//		
//		result.ifPresent(member -> log.info("member" + member));
	}

}

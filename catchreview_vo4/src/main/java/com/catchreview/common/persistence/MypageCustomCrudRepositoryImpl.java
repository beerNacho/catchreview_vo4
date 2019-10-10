package com.catchreview.common.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.catchreview.join.domain.QMember;
import com.catchreview.qnaBoard.domain.QnaBoard;
import com.catchreview.store.domain.QStore;
import com.catchreview.store.domain.Store;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.java.Log;

@Log
public class MypageCustomCrudRepositoryImpl extends QuerydslRepositorySupport implements CustomMypage{
// QuerydslPredicateExecutor<Store>
	public MypageCustomCrudRepositoryImpl() {
		super(QnaBoard.class);
	}

	@Override
	public Page<Object[]> getCustomPage(Long id, Pageable page) {
		
		log.info("================================");
		log.info("user_id: " + id);
		log.info("PAGE: " + page);
		log.info("================================");
		
		QStore s = QStore.store;
		QMember m = QMember.member;

		JPQLQuery<Store> query = from(s);
		
		JPQLQuery<Tuple> tuple = query.select(s.storeName, s.storeAddress1, s.storeAddress2, m.id);
		
		tuple.leftJoin(m);
		tuple.on(m.id.eq(s.user.id));
		tuple.where(s.user.id.eq(id));
		
		tuple.groupBy(m.id);
		
		tuple.offset(page.getOffset());
		tuple.limit(page.getPageSize());
		tuple.fetchCount();
		
		
		List<Tuple> list = tuple.fetch();
		
		List<Object[]> resultList = new ArrayList<>();
		
		list.forEach(t -> {
			resultList.add(t.toArray());
		});
		
		long total = tuple.fetchCount();
		
		return new PageImpl<>(resultList, page, total);
	}

}

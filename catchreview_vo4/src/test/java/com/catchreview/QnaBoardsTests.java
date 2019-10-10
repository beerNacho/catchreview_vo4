package com.catchreview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.catchreview.qnaBoard.domain.QnaBoard;
import com.catchreview.qnaBoard.domain.QnaReply;
import com.catchreview.qnaBoard.persistence.QnaBoardRepository;
import com.catchreview.qnaBoard.persistence.QnaReplyRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class QnaBoardsTests {

	@Autowired
	private QnaBoardRepository qnaBoardRepo;
	
	@Autowired
	private QnaReplyRepository qnaReplyRepo;
	@Test
	public void testInsert() {
		
		for(int i=0; i<=200; i++) {
			QnaBoard board = new QnaBoard();
			board.setTitle("title" + i);
			board.setContent("content" + i);
			board.setWriter("user" + i);
			
			qnaBoardRepo.save(board);
			
			for(int j=0; j<=5; j++) {
			QnaReply reply = new QnaReply();
			reply.setBoard(board);
			
			reply.setReplyText("text" + i);
			reply.setReplyer("replyer" + i);
			
			qnaReplyRepo.save(reply);
			}
		}
	}

}

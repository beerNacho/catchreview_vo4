package com.catchreview.qnaBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catchreview.qnaBoard.domain.QnaBoard;
import com.catchreview.qnaBoard.domain.QnaReply;
import com.catchreview.qnaBoard.persistence.QnaReplyRepository;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/replies/*")
public class QnaReplyController {

	@Autowired
	private QnaReplyRepository replyRepo;

	
	@Transactional
	@PostMapping("/{bno}")
	public ResponseEntity<List<QnaReply>> addReply(@PathVariable("bno") Long bno, @RequestBody QnaReply reply) {

		log.info("addReply...............");
		log.info("BNO: " + bno);
		log.info("REPLY: " + reply);

		QnaBoard board = new QnaBoard();
		board.setBno(bno);

		reply.setBoard(board);

		replyRepo.save(reply);

		return new ResponseEntity<>(getListByBoard(board), HttpStatus.CREATED);
	}

	private List<QnaReply> getListByBoard(QnaBoard board) throws RuntimeException {

		log.info("getListByBoard..." + board);
		return replyRepo.getRepliesOfBoard(board);
	}
	
	
	@Transactional
	@DeleteMapping("/{bno}/{rno}")
	public ResponseEntity<List<QnaReply>> remove(@PathVariable("bno") Long bno, @PathVariable("rno") Long rno) {

		log.info("delete reply: " + rno);

		replyRepo.deleteById(rno);

		QnaBoard board = new QnaBoard();
		board.setBno(bno);

		return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);
	}

	
	@Transactional
	@PutMapping("/{bno}")
	public ResponseEntity<List<QnaReply>> modify(@PathVariable("bno")Long bno,
			@RequestBody QnaReply reply){
		
		log.info("modify reply: " + reply);
		
		replyRepo.findById(reply.getRno()).ifPresent(origin -> {
			origin.setReplyText(reply.getReplyText());
			replyRepo.save(origin);
		});
		
		QnaBoard board = new QnaBoard();
		board.setBno(bno);
		
		return new ResponseEntity<>(getListByBoard(board), HttpStatus.CREATED);
	}
	
	@GetMapping("/{bno}")
	public ResponseEntity<List<QnaReply>> getReplies(
			@PathVariable("bno")Long bno){
		
		QnaBoard board = new QnaBoard();
		board.setBno(bno);
		
		log.info("get All Replies................" + getListByBoard(board));
		return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);
	}
	
}

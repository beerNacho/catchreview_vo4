package com.catchreview.qnaBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.catchreview.common.awsUpload.S3UploaderService;
import com.catchreview.qnaBoard.domain.QnaBoard;
import com.catchreview.qnaBoard.persistence.CustomCrudRepository;
import com.catchreview.qnaBoard.persistence.QnaReplyRepository;
import com.catchreview.qnaBoard.vo.PageMaker;
import com.catchreview.qnaBoard.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/qnaBoards/")
public class QnaBoardController {
	
	@Autowired
	private CustomCrudRepository qnaBoardRepo;
	//private QnaBoardRepository repo;
	
	@Autowired
	private QnaReplyRepository replyRepo;
	
	@Autowired
	private S3UploaderService s3Uploader;
	
	
	
	@GetMapping("/list")
	public void list(@ModelAttribute("pageVO")PageVO vo, Model model) {
		
		Pageable page = vo.makePageable(0, "bno");
		
//		Page<QnaBoard> result = repo.findAll(
//				repo.makePredicate(vo.getType(), vo.getKeyword()), page);
		
		Page<Object[]> result = qnaBoardRepo.getCustomPage(vo.getType(), vo.getKeyword(), page);
		
		log.info("" + page);
		log.info("" + result);
		
		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
		model.addAttribute("result", new PageMaker(result));
	}
	
	@GetMapping("/register")
	public void registerGet(@ModelAttribute("vo")QnaBoard vo) {
		log.info("register get");
	}
	
	@PostMapping("/register")
	public String resgisterPost(@ModelAttribute("vo")QnaBoard vo, RedirectAttributes rttr, @RequestParam("file")MultipartFile multipartFile) {
		log.info("register post");
		log.info("" + vo);
		log.info("file : " + multipartFile);
		
		qnaBoardRepo.save(vo);
		
		//s3Uploader.uploadfile(multipartFile);
		rttr.addFlashAttribute("msg", "success");
//		String filename = s3Uploader.uploadfile(multipartFile);
//		
		
		return "redirect:/qnaBoards/list";
	}
	
	@GetMapping("/view")
	public void view(Long bno, @ModelAttribute("pageVO") PageVO vo, Model model) {
		log.info("BNO: " + bno);
		
		qnaBoardRepo.findById(bno).ifPresent(board -> model.addAttribute("vo", board));
	}
	
	@GetMapping("/modify")
	public void modify(Long bno, @ModelAttribute("pageVO") PageVO vo, Model model) {
		log.info("MODIFY BNO: " + bno);
		
		qnaBoardRepo.findById(bno).ifPresent(board -> model.addAttribute("vo", board));
	}
	
	@PostMapping("/modify")
	public String modifyPost(QnaBoard board, PageVO vo, RedirectAttributes rttr) {
		log.info("Modify qnaBoard: " + board);
		
		qnaBoardRepo.findById(board.getBno()).ifPresent( origin ->{
			
			origin.setTitle(board.getTitle());
			origin.setContent(board.getContent());
			
			qnaBoardRepo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("bno", origin.getBno());
		});
		
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());
		
		return "redirect:/qnaBoards/view";
	}
	
	@PostMapping("/delete")
	public String delete(Long bno, PageVO vo, RedirectAttributes rttr) {
		log.info("DELETE BNO: " + bno);
		
//		Optional<QnaBoard> opBoard = qnaBoardRepo.findById(bno);
//		QnaBoard board = opBoard.get();
		

		
		log.info("DELETE Replies Complete");
		
		qnaBoardRepo.deleteById(bno);
		
		
		rttr.addFlashAttribute("msg", "success");
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());
		
		return "redirect:/qnaBoards/list";
	}
	
}

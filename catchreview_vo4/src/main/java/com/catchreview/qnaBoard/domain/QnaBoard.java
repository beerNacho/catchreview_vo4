package com.catchreview.qnaBoard.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_qnaboard")
@EqualsAndHashCode(of="bno")
@ToString(exclude="replies")
public class QnaBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	
	private String writer;
	private String content;
	
	private String filename;
	
	@CreationTimestamp
	private Timestamp regdate;
	
	@CreationTimestamp
	private Timestamp updatedate;
	
	@OneToMany(mappedBy="board", fetch=FetchType.LAZY)
	private List<QnaReply> replies;
	
}

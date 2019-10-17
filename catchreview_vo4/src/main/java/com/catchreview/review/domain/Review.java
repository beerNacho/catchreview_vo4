package com.catchreview.review.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.catchreview.store.domain.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_review")
@EqualsAndHashCode(of="reviewNum")
@ToString(exclude="store")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewNum;
	
	private String reviewTitle;
	
	private String reviewContent;
	
	private String filename;
	
	private String reviewWriteTime;
	
	private String visitDate;
	
	private int storeRate;
	
	private String writer;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Store store;

}

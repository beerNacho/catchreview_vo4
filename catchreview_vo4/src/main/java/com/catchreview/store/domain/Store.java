package com.catchreview.store.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.catchreview.join.domain.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_store")
@EqualsAndHashCode(of="storeNum")
@ToString(exclude="user")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeNum;
	
	private String storeName;
	
	private String storePhone;
	
	private String storeAddress1;
	
	private String storeAddress2;
	
	private String businessTime;
	
	private String storeHoliday;
	
	private String sotreIntro;
	
	private String filename1;
	
	private String filename2;
	
	private String filename3;
	
	private String filename4;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Member user;
}

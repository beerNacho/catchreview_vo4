package com.catchreview.store.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.catchreview.join.domain.Member;
import com.catchreview.reward.domain.Reward;
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
@ToString(exclude= {"user", "rewards"})
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeNum;
	
	@Column(nullable = false, unique = true)
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

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="store")
	private List<Reward> rewards;
}

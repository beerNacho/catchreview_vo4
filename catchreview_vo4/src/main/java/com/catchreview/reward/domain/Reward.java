package com.catchreview.reward.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.catchreview.point.domain.Point;
import com.catchreview.store.domain.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_reward")
@EqualsAndHashCode(of="rewardNum")
@ToString(exclude= {"store", "point"})
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rewardNum;
	
	private int rewardAmounts;
	
	private String fromDate;
	
	private String toDate;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Store store; 
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Point point;
	
}

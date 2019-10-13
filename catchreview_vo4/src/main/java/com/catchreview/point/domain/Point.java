package com.catchreview.point.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "tb_point")
@EqualsAndHashCode(of="pointNum")
@ToString(exclude= {"user", "histories"})
public class Point {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pointNum;
	
	private String io;
	
	private int pointAmounts;
	
	@CreationTimestamp
	private Timestamp ioTime;
	
	private String pointContent;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Member user;
	
	
	@OneToMany(mappedBy="point", fetch=FetchType.LAZY)
	private List<Reward> histories;
	
}
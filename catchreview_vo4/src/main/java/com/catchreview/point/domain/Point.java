package com.catchreview.point.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.catchreview.join.domain.Member;
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
@ToString(exclude= {"user"})
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
	
	
//	@OneToMany(mappedBy="point", fetch=FetchType.LAZY)
//	private List<Reward> histories;
	
}

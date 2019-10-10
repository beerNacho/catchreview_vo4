package com.catchreview.join.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_members")
@EqualsAndHashCode(of = "id")
@ToString
//@ToString(exclude="stores")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String uemail;
	
	private String upw;
	
	private String uname;
	
	private String uphone;
	
	private boolean uphoneCheck;
	
	private String uaddress1;
	
	private String uaddress2;
	
	private int ugrade;
 
	private String upicture;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedate;
	
//	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
//	private List<Store> stores;
	
}

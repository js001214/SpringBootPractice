package com.mysite.sbb2.Users;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Users {
	@Id // Primary Key
	@GeneratedValue (strategy = GenerationType.IDENTITY) //시퀀스할당
	private Integer idx;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 100)
	private String pass;
	
	@Column(length = 200)
	private String email;
	
	private LocalDateTime regdate;
	
	private int cnt;
	
}
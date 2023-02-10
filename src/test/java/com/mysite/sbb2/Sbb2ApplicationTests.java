package com.mysite.sbb2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mysite.sbb2.Users.Users;
import com.mysite.sbb2.Users.UsersRepository;

@SpringBootTest
@ContextConfiguration(classes = Sbb2Application.class)
public class Sbb2ApplicationTests {

	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void insert1000() {
		
		Users us = null;
		
		for (int i = 1; i <=1000 ; i++) 
		{
			us = new Users();
			us.setName("이름 - " + (i));
			us.setPass("pass1");
			us.setEmail("메일주소 - " + (i));
			us.setRegdate(LocalDateTime.now());
			us.setCnt(i);
			
			this.usersRepository.save(us);
		}
		
	}
	
	
	
	
	//idx4번 name 주소를 수정
	//idx3번 값 삭제
	//regdate컬럼을 기준으로 내림차순 (Desc)
	
	/*
	@Test
	public void desc() {
		// select * from Users 
		List<Users> all =
				this.usersRepository.findAllByOrderByNameDesc();
		
		for (int i = 0 ; i <all.size() ; i++) {
			Users d1 = all.get(i);
			
			System.out.println(d1.getName());
			System.out.println();
			
		}
		
	}
	*/
	
	
	
	/*
	@Test
	public void update() {
		Optional<Users> op1 =
				this.usersRepository.findById(4);
		Users up = op1.get();
		
		up.setName("수정된 이름");
		
		this.usersRepository.save(up);
	}
	  */
	 
	
	
	/*
	@Test
	public void delete()
	{
		//1. 테이블에서 삭제할 레코드를 op로 받아옴
		Optional<Users> op =
				this.usersRepository.findById(3);
		//2. Optional에 객체를 끄집어 낸다.
		Users d = op.get();
		//3. delete(d)
		this.usersRepository.delete(d);
		
	}
	*/
	
	/*
	@Test	//insert
	public void insert123() {
		//1. 테이블에 insert할 레코드를 먼저 select한다.
		Users u = new Users();
		u.setName("박주성4");	
		this.usersRepository.save(u);
		
	}
	*/
	
	
	
	/*
	@Test
	void contextLoads() {
	}
	*/

}

package com.mysite.sbb2.Users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

	private final UsersRepository usersRepository;
	public Users getUser(Integer idx) {
		Optional<Users> op = this.usersRepository.findById(idx);
		
		return op.get();
		
	}
	
	public void CreateUser(String email, String name, String pass){
		
		Users us = new Users();
		us.setName(name);
		us.setEmail(email);
		us.setPass(pass);
		us.setCnt(0);
		us.setRegdate(LocalDateTime.now());
		
		this.usersRepository.save(us);
	}
	
	
	//Controller에서 getList메소드 호출시 출력할 page 번호를 매개변수로 받는다.
	public Page<Users> getList(int page) {
		//최신글을 먼저 출력하기
		List<Sort.Order> sorts = new ArrayList();
		sorts.add(Sort.Order.desc("regdate"));
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return this.usersRepository.findAll(pageable);
		
		
	}
	
	
}
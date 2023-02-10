package com.mysite.sbb2.Users;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
}

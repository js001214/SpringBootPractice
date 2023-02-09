package com.mysite.sbb2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	// JPA 에서 사용 가능한 메소드 상속됨
	// findAll()
	// findById()
	// save()
	// delete()
	
	List<Users> findAllByOrderByNameDesc(); 
	
	

	
}

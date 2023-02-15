package com.mysite.sbb2.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	// JPA 에서 사용 가능한 메소드 상속됨
	// findAll()
	// findById()
	// save()
	// delete()
	
	List<Users> findAllByOrderByNameDesc(); 
	Page<Users> findAll(Pageable pageable);
	
}
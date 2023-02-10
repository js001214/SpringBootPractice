package com.mysite.sbb2.Users;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final 필드의 생성자를 자동으로 만든다.
@Controller	//QuestionController를 객체화해서 framework에 만들어준다.
public class UsersController {
	/*
	 @Component:일반적인 클래스를 객체화
	 @Controller : 클라이언트 요청을 받아서 처리, Controller
	 	1. 클라이언트 요청을 받는다. @GetMapping, @PostMapping
	 	2. 비즈니스 로직 처리, Service의 메소드 호출,
	 	3. View 페이지로 응답
	 	
	 	@Service : DAO의 메소드를 인터페이스로 생성후 인터페이스의 메소드를 구현한 클래스
	 		- 유지보수를 쉽게 하기 위해서 
	 	@Repository : DAO 클래스를 빈등록 (객체화)
 
	 */
	private final UsersService usersService;
	private final UsersRepository usersRepository;
	
	@GetMapping("/users/list")
	@PostMapping("/users/list")
	public String list(Model model) {
		
		//1. 클라이언트 요청 정보 http://localhost:9123/users/list
		
		//2. 비즈니스 로직 처리
		List<Users> usersList =
				this.usersRepository.findAll();
		
		//3. 뷰 (view) 페이지로 전송
			//Model : 뷰페이지로 서버의 데이터를 담아서 전송 객체 
		model.addAttribute("usersList",usersList);
		//model이라는 객체를 만들고 userList를 "userList"에 담아서 전송
		//model객체는 usersList를 가지고 있는 거야~
		return "Users_list";
	}
	@GetMapping(value = "/users/detail/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx) {
		
		Users u =
				this.usersService.getUser(idx);
				
		//Model 객체에 담아서 클라이언트에게 전송
		model.addAttribute("users", u);
		return "Users_detail";
	}
	
	@PostMapping("/users/create")
	public String create(@RequestParam("email") String email,@RequestParam("name") String name, @RequestParam("pass") String pass)
	{
		 
				this.usersService.CreateUser(email, name, pass);
		
		return String.format("redirect:/users/list");
	}
	
	
}

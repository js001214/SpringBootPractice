package com.mysite.sbb2.Users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersForm {
	
	// subject 폼의 값과 content 폼의 값의 유효성 체크
	
	@NotEmpty(message="이메일은 필수 사항입니다.")
	@Size (max=200)
	private String email;	//email 값이 비어있을때 작동
	
	@NotEmpty(message="이름은 필수 사항입니다.")
	private String name;
	
	@NotEmpty(message="비밀번호는 필수 사항입니다.")
	private String pass;
	

}

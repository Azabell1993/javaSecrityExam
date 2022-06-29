package com.jiwoo.security.config;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.jiwoo.domain.MemberSec;


public class SecurityUser extends User { 
	// 조회된 테이블의 내용을 스프링시큐리티가 요구하는 형태로 반드시 User를 상속받아서 생성자로 값을 넘김.

	private static final long serialVersionUID = 1L;
	
	public SecurityUser(MemberSec member) {
		super(member.getId(),member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
				
	}
	
	/* Member만들고 값을 입력하는데 member.setPassword(encoder.encode("jiwoo2") */
	
}

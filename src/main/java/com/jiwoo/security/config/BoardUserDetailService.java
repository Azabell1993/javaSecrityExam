package com.jiwoo.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jiwoo.domain.MemberSec;
import com.jiwoo.persistence.MemberRepository;

public class BoardUserDetailService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MemberSec> optional = memberRepo.findById(username);
		if( ! optional.isPresent() ) {
			throw new UsernameNotFoundException(username + "에 해당하는 사용자 없음");
		} else {
			MemberSec member = optional.get();
			return new SecurityUser(member);
		}
	}
}

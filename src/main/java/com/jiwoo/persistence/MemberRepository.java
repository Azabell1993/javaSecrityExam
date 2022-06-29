package com.jiwoo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jiwoo.domain.MemberSec;

public interface MemberRepository extends CrudRepository<MemberSec, String>{
	
}

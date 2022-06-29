package com.jiwoo.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
public class MemberSec {
	
	@Id
	private String id;
	private String password;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	
	
}

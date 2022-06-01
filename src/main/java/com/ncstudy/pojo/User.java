package com.ncstudy.pojo;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String username;
	private String password;
	private int age;
	private String status;   //状态:NORMAL正常  PROHIBIT禁用
	private String permission;
	private String gender;
	
	public User(String name, int age, String permission, String gender) {
		super();
		this.username = name;
		this.age = age;
		this.permission = permission;
		this.gender = gender;
	}

}

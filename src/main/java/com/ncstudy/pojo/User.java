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
	
	private int age;
	private String permission;
	private String gender;
	private String password;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 状态:NORMAL正常  PROHIBIT禁用
	 */
	private String status;

	
	public User(String name, int age, String permission, String gender) {
		super();
		this.username = name;
		this.age = age;
		this.permission = permission;
		this.gender = gender;
	}

}

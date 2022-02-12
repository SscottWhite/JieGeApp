package com.ncstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private int id;
	private String name;
	private int age;
	private String permission;
	private String gender;
	
	public User(String name, int age, String permission, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.permission = permission;
		this.gender = gender;
	}
	
	
}

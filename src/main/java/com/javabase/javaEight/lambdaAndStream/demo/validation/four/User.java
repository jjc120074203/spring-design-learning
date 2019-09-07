package com.javabase.javaEight.lambdaAndStream.demo.validation.four;

public class User {

	private String name;
	private int age;
	private Sex sex;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String name, int age, Sex sex, String email) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}

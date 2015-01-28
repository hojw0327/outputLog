package com.maple.dog;

import org.springframework.stereotype.Component;

@Component("dog1")
public class JindoDog implements Dog{
	
	private int age;
	
	public void setAge() {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public JindoDog(int age) {
		this.age = age;
	}
	
	@Override
	public String bark() {
		return "으르렁";
	}

}

package com.maple.dog;

import org.springframework.stereotype.Component;

@Component("dog2")
public class Poodle {
	
	public String bark() {
		return "낑낑";
	}

}

package com.maple.outputlog;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maple.dog.DogHouse;
import com.maple.outputlog.Analyze;
import com.maple.outputlog.ReadFile;

public class SpringMain {
	public static void main(String args[])
	{
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("/applicationContext.xml"); //스프링설정파일 통해서 객체 생성
		//applicationContext.xml파일에서 <bean>으로 만든게 싱글톤으로 만든 객체(Analyze 클래스의 analyze라는 객체로..)
		
		//Analyze analyze = (Analyze)context.getBean("analyze");//객체 가져오는것. ->getBean(Id값)(applicationContext.xml에 쓴)
		//System.out.println(analyze);
		
		//ReadFile readFile = (ReadFile)context.getBean("readFile");
		//System.out.println(readFile);
		
		DogHouse dogHouse = (DogHouse)context.getBean("dogHouse"); //DogHouse클래스의 객체 가져오기(id가 dogHouse로 지정돼있음)
		//DogHouse dogHose = (DogHouse)context.getBean(DogHouse.class); 이렇게 넣어도 됨.
		
		dogHouse.singDogSound();

	}
	
} 

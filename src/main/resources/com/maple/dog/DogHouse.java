package com.maple.dog;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogHouse {
	
	//@Autowired 
	//자동으로 객체값을 넣어주는 annotation  (진돗개 에서 annotation 지정해줬으므로 bean이 진돗개의 객체를 생성한 상태이므로 진돗개 객체가 들어감
	//진돗개의 annotation 풀고 푸들에게 걸어주면 푸들 객체 들어감
	//둘다 annotation 해주면 오류 난다.
	@Resource(name="dog1")
	//두개의 클래스에 다 annotation 이 있고 아이디가 지정돼있으면 이렇게 둘중 하나 id값 줘서 그 id값에 해당되는 객체가 들어가게 할 수 있다.
	private Dog dog;
	
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public void singDogSound() {
		System.out.println(dog.bark());
	}

}

package com.sparta.java_02;

import com.sparta.java_02.domain.user.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java02Application {

	public static void main(String[] args) {
		SpringApplication.run(Java02Application.class, args);
	}

//	User user = new User("이름", "이메일", "패스워드");
//
//	save(user) //<-- insert 쿼리 실행
//
//	user.setName("이름");
//	save(user)
//
//	//insert를 할때는 생성자로 만듦
//	//update Setter로 값 변경

	User user= User.builder()
			.name("이름")
			.email("이메일")
//			.passwordHash(null) //null인애들은 생략이 가능
			.build();
}

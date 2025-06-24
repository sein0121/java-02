package com.sparta.java_02.domain.user.controller;

import com.sparta.java_02.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor //final 필드들만 모아서 생성자를 만들어줌
public class UserController { //Controller 는 어떻게 운영될것인가 하는 손잡이 역할

  //1. 필드주입
//  @Autowired
//  private UserService userService; //전역변수

  //  2. 생성자 주입
  private final UserService userService;

//  @Autowired //생성자 주입시에는 Autowired 생략 가능
//  public UserController(UserService userService) {
//    this.userService = userService;
//  } => 생성자 주입도 귀찮다면 상단에 RequiredArgsConstructor 어노테이션 추가로 이 과정도 생략 가능

  //3. 수정자 주입(setter)
//  private UserService userService;
//
//  @Autowired
//  public void setUserService(UserService userService) {
//    this.userService = userService;
//  }

  public void save() {
    userService.save();
  }
}

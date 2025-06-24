package com.sparta.java_02.domain.user.controller;

import com.sparta.java_02.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController { //Controller 는 어떻게 운영될것인가 하는 손잡이 역할

  //1. 필드주입
//  @Autowired
//  private UserService userService; //전역변수

  //  2. 생성자 주입
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

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

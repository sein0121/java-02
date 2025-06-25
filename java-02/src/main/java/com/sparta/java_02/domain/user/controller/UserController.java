package com.sparta.java_02.domain.user.controller;

import com.sparta.java_02.domain.user.dto.UserRequest;
import com.sparta.java_02.domain.user.dto.UserSearchResponse;
import com.sparta.java_02.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor //final 필드들만 모아서 생성자를 만들어줌
@RequestMapping("/api/users")
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

  @GetMapping("/{userId}")
  public ResponseEntity<UserSearchResponse> findAll(
      //ResponseEntity - 응답값을 보낼때 header, body, http 상태값도 같이 보내는
      @RequestParam(name = "email", required = false) String email,
      @PathVariable Long userId) {
    //GET /api/users/sein?email="aaa@naver.com" , name과 인자값이 같을때 name 생략가능

//    return ResponseEntity.status(200).body(UserSearchResponse.builder().build());
    //ResponseEntity - builder 제공
    return ResponseEntity.ok(UserSearchResponse.builder().build());
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody UserRequest request) {
    //   잭손 -  request 는 json 형태로 들어오는데 이걸 객체로 변환해줌
    userService.save();
  }

  @PutMapping("/{userId}")
  public ResponseEntity<Void> update(@PathVariable Long userId,
      UserRequest request) { //post와 put은 같은 dto 사용해도 된다(협의가 필요)

  }

  @PatchMapping("/{userId}")
  public ResponseEntity<Void> updateStatus(@PathVariable Long userId) {

  }

  @DeleteMapping("/{userId}")
  public void delete(@PathVariable Long userId) {

  }
}

package com.sparta.java_02.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

  @NotNull //Validation
  String name;

  @Email //Validation
  String email;

  String password;

//  {"name":"홍길동"} -> json 형태

}

package com.sparta.java_02.domain.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSearchResponse { //다건 조회 , 단건조회는 UserResponse 로 빼는게 좋음

  String name;
  String email;

}

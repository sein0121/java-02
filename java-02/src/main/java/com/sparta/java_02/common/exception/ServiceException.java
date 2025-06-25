package com.sparta.java_02.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceException extends RuntimeException {

  String code;
  String message;

  public ServiceException(ServiceExceptionCode code) {
    super(code.getMessage());
    this.code = code.name(); //code.name - get 사용하지 않고 name 그대로 가져오면 ServiceExceptionCode의 키 값(NOT_FOUND_DATA)
    this.message = super.getMessage();
  }

  @Override
  public String getMessage() {
    return message;
  }
}

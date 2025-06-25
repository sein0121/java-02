package com.sparta.java_02.global.exception;

import com.sparta.java_02.common.exception.ServiceException;
import com.sparta.java_02.common.response.ApiResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestControllerAdvice //스프링에게 exception을 처리하는 코드라는 걸 알려줌
public class GlobalExceptionHandler {

  //이 핸들러 덕분에 service 로직 안에서 에러를 처리하지 않을 수 있다.
  @ExceptionHandler(ServiceException.class)
  //ServiceException 가 발생하면 handleResponseException 메서드를 실행하라는 어노테이션
  public ResponseEntity<?> handleResponseException(ServiceException ex) {
    return ApiResponse.error(ex.getCode(), ex.getMessage());
  }

}

package com.sparta.java_02.global.exception;

import com.sparta.java_02.common.exception.ServiceException;
import com.sparta.java_02.common.response.ApiResponse;
import java.util.concurrent.atomic.AtomicReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestControllerAdvice //스프링에게 exception을 처리하는 코드라는 걸 알려줌
public class GlobalExceptionHandler {

  private final String VALIDATE_ERROR = "VALIDATE_ERROR";
  private final String SERVER_ERROR = "SERVER_ERROR";

  //이 핸들러 덕분에 service 로직 안에서 에러를 처리하지 않을 수 있다.
  @ExceptionHandler(ServiceException.class)
  //ServiceException 가 발생하면 handleResponseException 메서드를 실행하라는 어노테이션
  public ResponseEntity<?> handleResponseException(ServiceException ex) {
    return ApiResponse.error(ex.getCode(), ex.getMessage());
  }

  //404 -> 400 - exception 이 잡아내지 못하는 에러 , 웹서버와 Controller 사이의 필터에서 나는 에러
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
    AtomicReference<String> errors = new AtomicReference<>("");
    ex.getBindingResult().getAllErrors().forEach(c -> errors.set(c.getDefaultMessage()));

    return ApiResponse.badRequest(VALIDATE_ERROR, String.valueOf(errors));
  }

  //404 -> 400 - requestParam 이 잘 안들어온 것
  @ExceptionHandler(BindException.class)
  public ResponseEntity<?> bindException(BindException ex) {
    AtomicReference<String> errors = new AtomicReference<>("");
    ex.getBindingResult().getAllErrors().forEach(c -> errors.set(c.getDefaultMessage()));

    return ApiResponse.badRequest(VALIDATE_ERROR, String.valueOf(errors));
  }

  //위의 3개에서 잡지못한 에러를 다 잡음
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> serverException(Exception ex) {
    return ApiResponse.serverError(SERVER_ERROR, ex.getMessage());
  }
}

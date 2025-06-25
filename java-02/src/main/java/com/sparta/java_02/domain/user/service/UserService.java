package com.sparta.java_02.domain.user.service;

import com.sparta.java_02.common.exception.ServiceException;
import com.sparta.java_02.common.exception.ServiceExceptionCode;
import com.sparta.java_02.domain.user.dto.UserSearchResponse;
import com.sparta.java_02.domain.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<UserSearchResponse> searchAll(Long userId) {
    if (ObjectUtils.isEmpty(userId)) {
//      throw new RuntimeException("유저가 없습니다"); //throw - 에러를 발생시킴
      throw new ServiceException(ServiceExceptionCode.NOT_FOUND_USER);  //우리가 만든 커스텀 exception
      //ServiceException 이 실행되면 handleResponseException 메서드가 실행되서 응답이 나갔으면 좋겠다, 응답값에는 ServiceExceptionCode
    }
    return new ArrayList<>();
  }

  public void save() {
//    userRepository.save();
  }

}

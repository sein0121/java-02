package com.sparta.java_02.domain.user.repository;

import com.sparta.java_02.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //JPA 의 라이브러리가 아님, 이 클래스 repository 라고 JPA 가 아니라 Spring 에게 알려줌
public interface UserRepository_0620 extends JpaRepository<User, Long> { //<엔티티명, pk 자료형>
////    User findByName(String name);
//
//    //Optional을 붙어야 null 처리 가능? 그래서 꼭 붙이는게 좋음
//    @Query("SELECT u FROM User u WHERE u.name = :name") //jpa 가 제공하는 sql : jpql
//    Optional<User> findUser(String name); //findByName 은 Name 만 찾으니까 활용도가 떨어질 수 있음
////    Optional<User> findFirstByName(String name); //여러개가 조회 될때 제일 첫번째 꺼만
////    Optional<User> findFirstByNameAndEmail(String name); //이름과 이메일 같이 찾기

  Optional<User> findByNameAndRoleAndAgreePersonal(String name, String role, boolean agreePersonal);
}

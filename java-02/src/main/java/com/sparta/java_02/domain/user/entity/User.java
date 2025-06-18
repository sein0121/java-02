package com.sparta.java_02.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table  //(name = users) 테이블명과 다를 때
@Entity
@DynamicInsert
@DynamicUpdate // Dynamic..- 편의성을 위해 주는 어노테이션 , 기존에 있는것과 변경된것만 업데이트
@NoArgsConstructor //(access = AccessLevel.PROTECTED)
public class User {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //JPA 는 id 까지는 인지, 밑에 필드들은 인지 하지 못함 -> @Column 어노테이션 추가

    @Column(name = "name", nullable = false, length = 50)  //컬럼명과 필드명이 동일할땐 name 생략가능
    private String name;

    @Column
    private String email;

    @Column
    private String phone;
    @Column
    private String role;
    @Column
    private String provider;
    @Column
    private String providerId;

    @Column(name = "password_hash", nullable = false) //컬럼명과 필드명이 동일할땐 name 생략가능, 언더바 사용한 카멜표기도 생략가능
    private String passwordHash;

    @Column
    private boolean agreePersonal;

    @Column(nullable = false, updatable = false) //update 막음
    @CreationTimestamp //createAt 은 자동으로 해주는 어노테이션 -> 비즈니스 로직에서 더이상 고민하지 않아도됨
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public User(
            String name,
            String email,
            String passwordHash
    ){
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}




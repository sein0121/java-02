package com.sparta.java_02.domain.purchase.entity;


import com.sparta.java_02.common.enums.PurchaseStatus;
import com.sparta.java_02.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Table
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  User user;

  @Column(name = "total_price") //스네이크 명명법은생략가능
  BigDecimal totalPrice;//BigDecimal - 정확도가 높음, 가격같은거에 사용

  @Enumerated(EnumType.STRING) // Enum 타입을 문자열로 저장
  @Column(nullable = false, length = 20)
  PurchaseStatus status; //실제로 컬럼상에는 varchar(20)으로 인식

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  LocalDateTime createdAt;

  @Column
  @UpdateTimestamp
  LocalDateTime updatedAt;

  @Builder
  public Purchase(
      User user,
      BigDecimal totalPrice,
      PurchaseStatus status) {
    this.user = user;
    this.totalPrice = totalPrice;
    this.status = status;
  }
}

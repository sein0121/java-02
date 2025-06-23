package com.sparta.java_02.domain.purchase.repository;

import com.sparta.java_02.common.enums.PurchaseStatus;
import com.sparta.java_02.domain.purchase.entity.Purchase;
import com.sparta.java_02.domain.user.entity.User;
import com.sparta.java_02.domain.user.repository.UserRepository;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@Transactional
@SpringBootTest //테스트용
public class PurchaseRepositoryTest {

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Autowired
  private UserRepository userRepository;

  @Test
  void save() {
    User user = userRepository.save(
        User.builder()
            .name("테스트유저")
            .email("test@test.com")
            .passwordHash("hashed")
            .build()
    );

//    User user = userRepository.findById(1L).get();

    Purchase purchase = Purchase.builder()
        .user(user)
        .totalPrice(BigDecimal.valueOf(1000))
        .status(PurchaseStatus.PENDING)
        .build();
    Purchase savePurchase = purchaseRepository.save(purchase);

//    List<Purchase> puchases = new ArrayList<>();
//    purchaseRepository.saveAll(puchases);
  }

  @Test
  void 수정() {
    User user = userRepository.save(
        User.builder()
            .name("테스트유저")
            .email("test@test.com")
            .passwordHash("hashed")
            .build()
    );

    Purchase purchase = Purchase.builder()
        .user(user)
        .totalPrice(BigDecimal.valueOf(1000))
        .status(PurchaseStatus.PENDING)
        .build();
    Purchase savePurchase = purchaseRepository.save(purchase);

    savePurchase.setStatus(PurchaseStatus.COMPLETION);
    purchaseRepository.save(savePurchase);

  }

  @Test
  void 삭제() {

  }
}

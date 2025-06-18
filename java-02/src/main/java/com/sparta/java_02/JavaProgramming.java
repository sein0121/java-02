package com.sparta.java_02;

// "알림을 보낼 수 있다"는 역할(약속)을 정의하는 인터페이스
interface Notifier {

  void send(String message);
}

// 약속을 실제로 이행하는 구현 클래스 1
class EmailNotifier implements Notifier {

  @Override
  public void send(String message) {
    System.out.println("이메일 발송: " + message);
  }
}

// 약속이행하는 구을 실제로 현 클래스 2
class SmsNotifier implements Notifier {

  @Override
  public void send(String message) {
    System.out.println("SMS 발송: " + message);
  }
}

public class JavaProgramming {

  public static void main(String[] args) {
    // Notifier 역할에 의존하여 코딩
    Notifier notifier;

    // 필요에 따라 이메일 구현체를 주입받아 사용
    notifier = new EmailNotifier();
    notifier.send("회원가입을 축하합니다!"); // 이메일 발송: 회원가입을 축하합니다!

    // SMS 구현체로 쉽게 교체 가능
    notifier = new SmsNotifier();
    notifier.send("인증번호는 [1234] 입니다."); // SMS 발송: 인증번호는 [1234] 입니다.
  }
}

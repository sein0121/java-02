package com.sparta.java_02;

// 클래스 선언 (설계도)
class Car {

  // 메소드
  void move() {
    System.out.println("자동차가 움직입니다.");
  }
}
//------------

class Student {

  private int score; // 외부에서 직접 접근 불가

  // Getter: 데이터를 읽는 통로
  public int getScore() {
    return this.score;
  }


  // Setter: 데이터를 쓰는 통로 (조건 검증 추가)
  public void setScore(int score) {
    if (score >= 0 && score <= 100) {
      this.score = score;
    } else {
      System.out.println("유효하지 않은 점수입니다.");
    }
  }
}

//--------------------
class Animal {

  void eat() {
    System.out.println("음식을 먹습니다.");
  }
}

// 자식 클래스 (Animal을 상속)
//class Dog extends Animal {
//
//  void bark() {
//    System.out.println("멍멍!");
//  }
//}
//----------------
// 역할(인터페이스) 정의
interface Speaker {

  void makeSound();
}

// 역할을 구현한 실제 객체 1
class Dog implements Speaker {

  @Override
  public void makeSound() {
    System.out.println("멍멍!");
  }
}

// 역할을 구현한 실제 객체 2
class Cat implements Speaker {

  @Override
  public void makeSound() {
    System.out.println("야옹~");
  }
}


public class JavaProgramming1 {

  public static void main(String[] args) {
    // 객체 생성 (실체화)
    Car myCar = new Car();
    myCar.move(); // 자동차가 움직입니다.

    Car yourCar = new Car();
    yourCar.move(); // 자동차가 움직입니다.
    //-----------------------------

    Student student = new Student();
    // student.score = 200; // 컴파일 에러! private 필드는 직접 접근 불가

    student.setScore(95);
    System.out.println("학생의 점수: " + student.getScore()); // 학생의 점수: 95

    student.setScore(150); // 유효하지 않은 점수입니다.
    System.out.println("학생의 점수: " + student.getScore()); // 학생의 점수: 95 (이전 값 유지)
    //---------------------

//    Dog myDog = new Dog();
//    myDog.eat();  // 부모로부터 상속받은 메소드 호출
//    myDog.bark(); // 자식이 가진 고유한 메소드 호출
    //------------------

    // Speaker라는 역할(타입)에 의존
    // 상황에 따라 Dog 객체를 주입받을 수도 있고,
    Speaker pet = new Dog();
    pet.makeSound(); // 멍멍!

    // Cat 객체를 주입받을 수도 있다.
    pet = new Cat();
    pet.makeSound(); // 야옹~
    // 사용하는 쪽의 코드는 변경되지 않는다!

  }
}

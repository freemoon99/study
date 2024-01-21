package ch6.스코프와형변환;

public class Scope {

  public static void main(String[] args) {
//    지역 변수란?
//    지역변수는 특정 지역에서만 사용할 수 있는 변수
//    지역 => 변수가 선언된 코드 블록
    int m = 10; // m 생존 시작

    if (true) {
      int x = 20; // x 생존 시작
      System.out.println("if m = " + m);
      System.out.println("if x = " + x);
    } // x 생존 종료

    System.out.println("main m = " + m);
    System.out.println("main x = " + x);  // err 발생

//    스코프 존재 이유
    int m1 = 10;
    int temp = 0;
    if (m1 > 0) {
      temp = m1 * 2;
      System.out.println("temp = " + temp);
    }
    System.out.println("m = " + m1);

//    1. 비효율적인 메모리 사용
//    2. 코드 복잡성 증가
//    좋은 예
//    temp의 경우 사용하는 곳에서만 한정해주기 때문에 -> 즉, 필요한 곳에서 필요한 것만 사용
    int m2 = 10;
    if (m2 > 0) {
      int temp1 = m * 2;
      System.out.println("temp = " + temp1);
    }
    System.out.println("m = " + m2);
  }

//  변수는 꼭 필요한 범위로 한정해서 사용하는 것이 좋다. 변수의 스코프는 꼭 필요한 곳으로 한정해서 사용하자.
// 메모리를 효율적으로 사용하고 더 유지보수하기 좋은 코드를 만들 수 있다.
// 좋은 프로그램은 무한한 자유가 있는 프로그램이 아니라 적절한 `제약`이 있는 프로그램이다.
}

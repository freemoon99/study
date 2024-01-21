package ch6.스코프와형변환;

public class Casting {

  public static void main(String[] args) {
//    형변환 1 : 자동 형변환
//    작은 범위 에서 큰 범위로는 가능 (역으로는 불가) -> 자바가 자동으로 형 변환 함
//    int -> long -> double 가능

//    형변환 2 : 명시적 형변환
    int intValue = 0;
    double doubleValue = 1.5;
    intValue = (int) doubleValue;
    intValue = (int) 1.5; //doubleValue에 있는 값을 읽는다.
    intValue = 1; //(int)로 형변환 한다. intValue에 int형인 숫자 1을 대입한다.

//    형변환 오버플로우 -> 조심해야함
    long maxIntValue = 2147483647; //int 최고값
    long maxIntOver = 2147483648L; //int 최고값 + 1(초과)

    maxIntValue = 2147483647; //int 최고값
    intValue = (int) maxIntValue; //변수 값 읽기
    intValue = (int) 2147483647L; //형변환
    intValue = 2147483647;

    maxIntOver = 2147483648L; //int 최고값 + 1
    intValue = (int) maxIntOver; //변수 값 읽기
    intValue = (int) 2147483648L; //형변환 시도
    intValue = -2147483648;

//    정리 : 형변환
//    `int` -> `long` -> `double`
//    - 작은 범위에서 큰 범위로는 대입할 수 있다.
//       - 이것을 묵시적 형변환 또는 자동 형변환이라 한다.
//    - 큰 범위에서 작은 범위의 대입은 다음과 같은 문제가 발생할 수 있다. 이때는 명시적 형변환을 사용해야 한다.
//       - 소수점 버림
//       - 오버플로우
//    - 연산과 형변환
//       - 같은 타입은 같은 결과를 낸다.
//       - 서로 다른 타입의 계산은 큰 범위로 자동 형변환이 일어난다.

  }
}

package ch5.반복문;

public class Loop {

  public static void main(String[] args) {
    int count = 0;

    count = count + 1;
    System.out.println(count);
    count = count + 1;
    System.out.println(count);
//    위의 반복 과정을 편하게 하기 위해서 for 혹은 while과 같은 반복문을 사용함
//    while문
//    while (조건식) {
//      참이면 코드 실행
//    }
//    거짓이면 밖

    while (count < 10) {
      count = count + 1;
      System.out.println(count);
    }

//    do-while문, 조건에 상관없이 1번은 무조건 동작함
    do {

    } while (조건식);

//    break와 continue
//    break는 반복문을 즉시 종료
//    continue는 나머지 부분을 건너띄고 다음을 실행

//    for문
    for(1. 초기식; 2. 조건식; 4. 증감식){
      3. 코드
    }

    for (int i=0; i<10; i++){
      System.out.println(i);
    }

//    다음의 코드는 while가 같은 무한 반복
    for (;;){

    }

//    별찍기
    int rows = 5;
    for (int i=0; i<=rows; i++){
      for (int j=0; j<=i; j++){
        System.out.println("*");
      }
      System.out.println();
    }
  }
}

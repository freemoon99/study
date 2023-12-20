package ch4.조건문;

public class Conditional {
    public static void main(String[] args) {
//        if문 -> 특정 조건이 참인지 거짓인지 판단
//        else문 -> if에 만족하는 조건이 없는 경우
//        else if문
//        if 로만 구현할 경우 단점
//        1. 불필요한 조건 검사가 필요하다.
//        예를 들어 첫번째 if에 해당하는데 그 다음에 나오는 if들도 모두 검증해야 함 -> 중복 체크
//        2. 코드의 효율성
//        전체 구문에서 해당 조건에 해당하는 부분을 실행하고 if-else if 블록 전체를 벗어남
//        if - else if
//        묶어서 사용할 경우에는 요구 사항을 잘 파악해야함
//        서로 다른 조건이 동시에 적용되는 경우 ex) 가격할인 + 나이할인 에는 if, if로 구현하는게 맞음

//        다음과 같은 경우에는 두번째 문장은 `if` 문과 무관하다. 만약 둘다 `if` 문 안에 포함하려면 `{}` 를 사용해야 한다.
        if (true)
            System.out.println("if문에서 실행됨");
        System.out.println("if문에서 실행 안됨");
//        만약 둘다 `if` 문 안에 포함하려면 다음과 같이 `{}` 를 사용해야 한다.
        if (true) {
            System.out.println("if문에서 실행됨");
            System.out.println("if문에서 실행 안됨");
        }

//        switch
//        switch (조건식) {
//            case value1:
//              조건식의 결과 값이 value1일 때 실행되는 코드
//                break;
//            case value2:
//              조건식의 결과 값이 value2일 때 실행되는 코드
//                break;
//            default:
//              조건식의 결과 값이 위의 어떤 값에도 해당하지 않을 때 실행되는 코드
//        }

//        삼항 연산자
//        (조건) ? 참_표현식 : 거짓_표현식
        int age = 18;
        String status = (age >= 18) ? "성인" : "미성년자";
        System.out.println("age = " + age + " status = " + status);

//        문제 1 학점 계산기
        int score = 100;
        if (score >= 90) {
            System.out.println("학점은 A입니다.");
        } else if (score >= 80) {
            System.out.println("학점은 B입니다.");
        } else if (score >= 70) {
            System.out.println("학점은 C입니다.");
        } else if (score >= 60) {
            System.out.println("학점은 D입니다.");
        } else {
            System.out.println("학점은 F입니다.");
        }
        
//        문제 2. 거리에 따른 운송 수단 선택하기
        int distance = 100;
        if (distance <= 1) {
            System.out.println("도보를 이용하세요.");
        } else if (distance <= 10) {
            System.out.println("자전거를 이용하세요.");
        } else if (distance <= 100) {
            System.out.println("자동차를 이용하세요.");
        } else {
            System.out.println("비행기를 이용하세요.");
        }

//        문제 3. 환율 계산하기
        int dollar = 10;
        if (dollar < 0) {
            System.out.println("잘못된 금액입니다.");
        } else if (dollar == 0) {
            System.out.println("환전할 금액이 없습니다.");
        } else {
            int won = dollar * 1300;
            System.out.println("환전 금액은 " + won + "원입니다.");
        }

//        문제 4. 평점에 따른 영화 추천
        double rating = 7.1;
        if (rating <= 9) {
            System.out.println("'어바웃타임'을 추천합니다.");
        }
        if (rating <= 8) {
            System.out.println("'토이 스토리'를 추천합니다.");
        }
        if (rating <= 7) {
            System.out.println("'고질라'를 추천합니다.");
        }
        
//        문제 5. 학점에 따른 성취도 출력하기
        String grade = "B";
        switch(grade) {
            case "A":
                System.out.println("탁월한 성과입니다!");
                break;
            case "B":
                System.out.println("좋은 성과입니다!");
                break;
            case "C":
                System.out.println("준수한 성과입니다!");
                break;
            case "D":
                System.out.println("향상이 필요합니다.");
                break;
            case "F":
                System.out.println("불합격입니다.");
                break;
            default:
                System.out.println("잘못된 학점입니다.");
        }

//        문제 6. 더 큰 숫자 찾기
        int a = 10;
        int b = 20;
        int max = (a > b) ? a : b;
        System.out.println("더 큰 숫자는 " + max + "입니다.");

//        문제 7. 홀수 짝수 찾기
        int x = 2;
        String result = (x % 2 == 0) ? "짝수" : "홀수";
        System.out.println("x = " + x + ", " + result);
    }
}

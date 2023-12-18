package ch3.연산자;

public class Operater {
    public static void main(String[] args) {
//        연산자 = 사칙연산과 같은 연산하는 기호
//        피연산자 = 연산을 수행할 대상

//        1. 산술연산자
        int a = 5;
        int b = 2;
//        연산 +-*/ 다 같은 모양으로
        int sum = a+b;
        System.out.println(sum);
//        나머지 연산
        int mod = a%2;
        System.out.println(mod);
//        0으로 나누는것은 x, err발생
//        int z = 10/0;
//        System.out.println(z);

//        2. 문자열 더하기
        String res1 = "hello" + "world";
        System.out.println(res1);

        String s1 = "string1";
        String s2 = "string2";
        System.out.println(s1+s2);
//        문자열 + 숫자 -> 숫자를 문자로 변경해서 더해줌
        int num = 20;
        System.out.println(s1+num);
//        따라서 문자열에 더하는 모든 것들은 문자열로 변환됨

//        3. 연산자 우선순위
        int sum1 = 1+2*3;
        int sum2 = (1+2)*3;
        System.out.println(sum1);
        System.out.println(sum2);
//        괄호를 사용하면 괄호 우선
//        연산자 우선순위가 애매하거나 복잡하지면 무조건 "()" 괄호 추가하기

//        4. 증감연산자
        int a1 = 0;
        a1 = a1+1;
        System.out.println(a1);//1
        a1++;
        System.out.println(a1);
        ++a1;   // a1 = a1+1
        System.out.println(a1);
//        전위, 후위 증감연산자
        ++a1;  // 전위 a1의 값을 먼저 증가시키고, 그 결과를 b에 대입
        a1++;  // 후위

        int a2 = 1;
        int b2 = 0;
        b2 = ++a2;  // a의 값을 먼저 증가시키고, 그 결과를 b에 대입
        System.out.println("a2 = "+a2+" b2 = "+b2); //a2 = 2 b2 = 2

        int a3 = 1;
        int b3 = 0;
        b3 = a3++;  //a의 현재 값을 먼저 b에 대입하고, 그 후에 a의 값을 증가시킴
        System.out.println("a3 = "+a3+" b3 = "+b3); //a3 = 2 b3 = 1

//        다만, a++, ++a처럼 단독으로 쓸 경우에는 값이 같다. -> 변수에 저장될 때만 다름

//        5. 비교 연산자
        System.out.println(a == b); // false, a와 b는 같지 않다
        System.out.println(a != b); // true, a와 b는 다르다
        System.out.println(a > b); // false, a는 b보다 크지 않다
        System.out.println(a < b); // true, a는 b보다 작다
        System.out.println(a >= b); // false, a는 b보다 크거나 같지 않다
        System.out.println(a <= b); // true, a는 b보다 작거나 같다
//        결과를 boolean 변수에 담기
        boolean result = a == b; //a == b: false
        System.out.println(result); //false
//          문자열은 .equals() 를 사용
        String str1 = "문자열1";
        String str2 = "문자열2";
        boolean result1 = "hello".equals("hello"); //리터럴 비교
        boolean result2 = str1.equals("문자열1");//문자열 변수, 리터럴 비교
        boolean result3 = str1.equals(str2);//문자열 변수 비교
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        
//        6. 논리 연산자
//        && = and, || or, ! 부정
        System.out.println("&&: AND 연산");
        System.out.println(true && true); //true
        System.out.println(true && false);//false
        System.out.println(false && false);//false
        System.out.println("||: OR 연산");
        System.out.println(true || true); //true
        System.out.println(true || false);//true
        System.out.println(false || false);//false
        System.out.println("! 연산");
        System.out.println(!true); //false
        System.out.println(!false); //true


//        7. 대입연산자
//        축약 연산자 => `+=` , `-=` , `*=` , `/=` , `%=`
        a += 3; // 8 (5 + 3): a = a + 3
        a -= 2; // 6 (8 - 2): a = a - 2
        a *= 4; // 24 (6 * 4): a = a * 4
        a /= 3; // 8 (24 / 3): a = a / 3
        a %= 5; // 3 (8 % 5) : a = a % 5
        System.out.println(a);
    }
}

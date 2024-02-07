# IT 대기업 현업 개발자와 함께 하는 백엔드 개발 실무
- '2024. 01. 11 ~ 2024. 02. 08'

## 1주차 : 개발환경 셋팅
- Java: Oracle JDK 8 (version "1.8.0_221")_ <br>
- Eclipse IDE: 2019-06 <br>
- Tomcat: 9.0.85_ <br>
- MariaDB: 10.2.14_ <br>
- MySQL Workbench: 8.0.34_ <br>

### 내용
- JDK 1.8, Eclipse, Spring 다운로드 및 설치
- 톰캣 설정 및 Hello World 출력
- mariaDB, mySql WorkBench 설치 및 샘플 DB 구축
- 스프링, Mariadb, MyBatis 연동, 데이터 조회

### 문제점 : sts 설치 문제
이클립스 sts 설치 문제는 다음과 같이 해결하였습니다.
1. 자바 버전 문제 -> 1.8버전 재설치 후 진행하였습니다.
2. 이클립스 버전은 2019-06
3. 이클립스 marketplace에서 sts 버전 다운을 Spring Tools 3 (Standalone Edition) 3.9.14 릴리즈 버전으로 다운 받아줬습니다.

## 2주차 : API 가이드 문서 작성
### 내용
- Rest API가 무엇인지 학습
1. HTTP 통신에 관하여
2. 브라우저에 URL을 입력 후 요청하여 서버에서 응답하는 과정까지에 대해 학습 한 내용을 작성
- API 가이드라인 작성
  - 카카오 API 가이드 참고

## 3주차 : 간단한 Restful API 구현
### 내용
- spring boot를 활용한 api 개발
- 스프링 VS 스프링부트 차이 이해

### 개발 환경
- JAVA 17
- IntelliJ
- Spring Boot 3.2.2
- maven
- dependency
  - MyBatis Framework
  - Spring Boot DevTools
  - Lombok
  - Spring Web
  - JDBC API
  - MariaDB Driver

### 배운점
- maven 의존성 최신 버전 확인 : https://central.sonatype.com/
- 경로 오류로 jsp 연동이 안되었음
  - demo 밑에 test가 DemoApplication과 같은 레벨로 놓여져 있었어야 함

### 업무 진행 현황
#### [3-1] 스프링부트로 개발 환경 설정하기
![image](https://github.com/freemoon99/study/assets/102667851/11bc84b5-3921-4889-8188-2f637c9b9306)

#### [3-2] 통계(SW활용현황) API를 위한 DB, Table 생성
![image](https://github.com/freemoon99/study/assets/102667851/d01ab223-08ec-481c-a970-01c53ab2cb5e)

#### [3-3] [20년도 로그인수 API] 스프링부트, Mybatis, mariadb 연동
<<<<<<< HEAD
![이미지3](</assets/스크린샷 2024-02-02 005309.png>)


## 4주차 : SW 활용 현황 API 구현 및 API 가이드 문서 보완
### 내용
- 3주차에 작성한 SQL을 바탕으로 총 5가지의 SW 활용 현황 Restful API 개발
- 본인이 개발한 내용을 바탕으로 2주차 API 가이드 문서를 보완하여 완성

### 개발 환경
- JAVA 17
- IntelliJ
- Spring Boot 3.2.2
- maven
- dependency
  - MyBatis Framework
  - Spring Boot DevTools
  - Lombok
  - Spring Web
  - JDBC API
  - MariaDB Driver

### 진행
- api 생성
- mybatis 연결을 위한 xml 경로 수정
- api 명세서 postman [링크](https://documenter.getpostman.com/view/25023872/2s9Yyy8JBq)
=======
![image](https://github.com/freemoon99/study/assets/102667851/88734f02-c41f-462d-98da-597d2cb6e31a)
>>>>>>> 9fbf728e91c7323818d982093e80fb52ce685016

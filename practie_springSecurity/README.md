# Spring Security
## practice_OAuth2.0
OAuth 기능을 이용하여 깃허브와 연동한 로그인

OAuth란? 타 플랫폼(카카오, 네이버, 구글, 페이스북 등...) 에서 접근 권한을 위임 받아서 사용할 수 있게 해주는 역할!

따로 회원가입 기능을 구현하지 않아되므로 연습삼아 시도해봤습니다!

### 1. OAuth란?

OpenID Authentication의 약자로 타사의 사이트에 대한 접근 권한을 얻고 그 권한을 이용하여 개발할 수 있도록 도와주는 프레임워크이다. 

쉽게 내 서비스들을 이용할때 너희(네이버, 구글, 카카오, 페이스북등등) 서비스를 이용하는 유저의 정보에 접근할 수 있는 권한을 위임해줘! 하는 것이다. 가장 많이 사용하는 예시로는 sns 소셜 로그인이 있다!

### 2. OAuth를 선택한 이유

우선 가벼운 마음으로 시작한(설계를 하면서 가볍지 않다는 것을 깨닳았다…) 토이 프로젝트였기 때문에 sns 로그인을 쓰는 것이 효율적이라고 생각다.

또한, 타 프로젝트에서 직접 구현해봤기에 이번에는 연동하는 방향으로 진행해 보고 싶었다.

#### vs JWT

이전에 적용해봤던 JWT와는 다르게 토큰 자체에는 큰 의미가 없다. 데이터를 갖고 있는 토큰을 주는 JWT와는 달리 ********권한을 확인하고 서비스 제공자에게 데이터를 요청********한다.

### 4. 연동 플랫폼 선정

네이버, 구글, 카카오, 페이스북과 같이 많은 플랫폼에서 사용하는 인증이 있었지만, 뭔가 github로 연동하고 싶었다. 개발자이기도 하고, 아무래도 코드 리뷰를 목적으로 만들려는 것이기에 github로 연동하면 뭔가 있어보인다고 생각했다..!!

### dependency

- spring security OAuth 2.0 client
- jpa
- lombok
- mysql connector

## 에러 발생
오류 발생…

### 1. Spring Security 공부를 하다가 오류가 발생했다.

<img width="1000" alt="image" src="https://github.com/freemoon99/study/assets/102667851/064488be-c45f-426c-92fc-0cfa0258b9d3">

강의에서는 잘 되던 인터페이스 상속이 되지 않는 문제... 찾아보니 이제 지원이 안되고 @Bean 으로 생성해서 써야 한다고 한다.

-> RequesMacthers 말고 antMatchers를 사용해야 함

### 2. config
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(auth->{
                    auth.antMatchers("/").permitAll();
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())
                .build();
    }
}
```
이 코드를 통해서  auth.antMatchers("/").permitAll();가 /인 링크만 허용해주고

나머지 링크는 oauth2 연결을 통해서 로그인을 한 이후에만 허용이된다는 설정 → 다른 페이지들은 인증이 필요하다는 뜻!!!

### 3. OAuth2.0을 적용하기 위한 전체적인 통신 구조

1. 프론트 서버에서 깃허브로 사용자의 로그인 요청을 보냅니다.
2. 깃허브 로그인 성공 시 프론트 서버로 callback 한다. 이때 프론트 서버에서 code를 얻게 됩니다.
3. 프론트 서버에서 백엔드 서버로 code를 보내 사용자 정보를 얻는 요청을 합니다.
4. 백엔드 서버에서 엑세스 토큰을 얻고, 사용자 정보를 얻습니다.
5. 백엔드 서버에서 사용자 정보를 프론트 서버로 응답합니다.

---
## springboot+jwt
정석적인 jwt를 이용하여 refresh token, acces token을 할당 받아서 로그인, 회원가입을 구현함

---
### 참고자료
[[무료] 스프링부트 시큐리티 & JWT 강의 - 인프런 | 강의](https://www.inflearn.com/course/스프링부트-시큐리티/dashboard) </br>
[OAuth2 Login Made Easy in Java: A Spring Boot & Spring Security Walkthrough](https://www.youtube.com/watch?v=us0VjFiHogo)</br>
[[OAuth + Spring Boot + JWT] 4. 스프링 시큐리티없이 OAuth 로그인 구현하기](https://velog.io/@max9106/OAuth4)</br>
[Spring Security + JWT를 이용한 자체 Login & OAuth2 Login(구글, 네이버, 카카오) API 구현 (1) - 회원(User) 관련 클래스 생성](https://ksh-coding.tistory.com/57)</br>
[OAuth - GitHub 로그인2](https://velog.io/@bongf/study-OAuth-GitHubLogin2)</br>
[jwt 토큰의 이해](https://inpa.tistory.com/entry/WEB-%F0%9F%93%9A-Access-Token-Refresh-Token-%EC%9B%90%EB%A6%AC-feat-JWT)</br>

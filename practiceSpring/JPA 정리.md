## JPA
- JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.
- JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.
- JPA를 사용하면 개발 생산성을 크게 높일 수 있다

추후에 책도 한번 읽어 봐야겠다..

참고!
- show-sql : JPA가 생성하는 SQL을 출력한다.
- ddl-auto : JPA는 테이블을 자동으로 생성하는 기능을 제공하는데 none 를 사용하면 해당 기능을 끈다.
create 를 사용하면 엔티티 정보를 바탕으로 테이블도 직접 생성해준다.


> AI를 이용해서 정리할때 참고했습니다! AI를 배척하기 보다는 적극 활용해보고자 합니다.

- 우선 스프링 부트와 JPA 쓰면, 개발 생산성이 엄청 증가하고 코드도 많이 줄어든다고 합니다.
- 스프링 데이터 JPA 쓰면, 리포지토리 구현 클래스 안 써도 인터페이스만으로 개발 가능해져서 반복작업 줄일 수 있다고 합니다. 
- CRUD 기능도 다 제공하고, 핵심 비즈니스 로직에 집중할 수 도와줍니다.

이러한 이유들 때문에 현업에서 JPA를 많이 사용하는 것이 아닐까 생각합니다. 저도 개인적으로 구현 연습을 해봤을때 정말 편한 기술이지만, 깊게 파고들면 어렵다고 느꼈습니다..!

---
#### JPA를 사용할 때 주의할 점은 다음과 같습니다.

1. 올바른 엔티티 매핑: 객체와 테이블 간의 매핑을 올바르게 설정해야 합니다.

2. 영속성 관리: JPA는 객체와 데이터베이스 간의 영속성을 관리하게 됩니다. 그러므로 개발자는 트랜잭션 내에서만 엔티티를 수정하도록 주의해야 합니다.

3. 지연 로딩 설정: JPA는 기본적으로 즉시 로딩(fetch=FetchType.EAGER)을 하도록 설정되어 있습니다. 이 때문에 원하지 않는 쿼리가 발생할 가능성이 있으므로, 필요한 경우 충분한 테스트를 거친 후 지연 로딩(fetch=FetchType.LAZY)으로 설정해야 합니다.

---
#### 장점은 다음과 같습니다.

1. 객체 지향적인 코드로 개발 가능: SQL을 직접 작성해야 하는 JDBC(Java DataBase Connectivity)와 달리, JPA는 객체 지향적인 코드로 개발이 가능합니다.

2. 생산성 향상: 객체와 테이블 간의 매핑이 자동으로 처리되므로, 개발자는 코드 작성에 집중할 수 있습니다.

3. 데이터베이스 독립성: JPA는 특정 데이터베이스 제품에 의존하지 않으므로, 데이터베이스를 변경하는 경우도 쉽게 대처할 수 있습니다.

#### 단점은 다음과 같습니다.

1. 학습 곡선이 높음: JPA는 ORM 기술이므로, 기존의 JDBC 기술에 대한 이해가 높아야 합니다.

2. 문제 해결이 어려울 수 있음: JPA는 ORM 기술로써 추상화가 높습니다. 이로 인해 일부 문제의 원인 파악이 어려울 수 있습니다.
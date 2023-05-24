jdbc... 옛날의 개발자들이 작성한 코드라고 해서
김영한 강사님의 강의를 보고 클론코딩 하다가 놀랐다..

확실히 발전한 이유가 있다..

이 코드를 작성하고, 교체하면서 OOP의 장점을 알 수 있었다.(단, 자바 코드로 직접 스프링 빈을 등록한 경우!!!)
아래 코드에서 `MemoryMemberRepository` 이 부분을 `JdbcMemberRepository` 이렇게 수정하면 구조체가 통째로 변환되는 것을 알 수 있다.

(물론 파라미터값은 채워 넣어야 한다. 자세한 것은 강의를 보는 것을 추천한다!) 


```java
//config 파일에서
@Configuration
public class SpringConfig{
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
```

### 테스트 
`@SpringBootTest` : 스프링 컨테이너와 테스트를 함께 실행한다.

`@Transactional` : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고,
테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지
않는다.

코드는 영한님 강의 참고하시길..!



쓸때 없이 코드를 작성해봤는데... 괜히 했다.. 이후에 MyBatics랑 JDBC템플릿도 잠깐 봤는데 

이래서 다들 JPA를 사용하는 게 아닌가 싶다..!

```java
package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class JdbcMemberRepository implements MemberRepository {
 private final DataSource dataSource;
 public JdbcMemberRepository(DataSource dataSource) {
 this.dataSource = dataSource; }
 @Override
 public Member save(Member member) {
 String sql = "insert into member(name) values(?)";
 Connection conn = null;
 PreparedStatement pstmt = null;
 ResultSet rs = null;
 try {
 conn = getConnection();
 pstmt = conn.prepareStatement(sql,
Statement.RETURN_GENERATED_KEYS);
 pstmt.setString(1, member.getName());
 pstmt.executeUpdate();
 rs = pstmt.getGeneratedKeys();
 if (rs.next()) {
 member.setId(rs.getLong(1));
 } else {
 throw new SQLException("id 조회 실패");
 }
 return member;
 } catch (Exception e) {
 throw new IllegalStateException(e);
 } finally {
 close(conn, pstmt, rs);
 }
 }
 @Override
 public Optional<Member> findById(Long id) {
 String sql = "select * from member where id = ?";
 Connection conn = null;
 PreparedStatement pstmt = null; ResultSet rs = null;
 try {
 conn = getConnection();
 pstmt = conn.prepareStatement(sql);
 pstmt.setLong(1, id);
 rs = pstmt.executeQuery();
 if(rs.next()) {
 Member member = new Member();
 member.setId(rs.getLong("id"));
 member.setName(rs.getString("name"));
 return Optional.of(member);
 } else {
 return Optional.empty();
 }
 } catch (Exception e) {
 throw new IllegalStateException(e);
 } finally {
 close(conn, pstmt, rs);
 }
 }
 @Override
 public List<Member> findAll() {
 String sql = "select * from member";
 Connection conn = null;
 PreparedStatement pstmt = null;
 ResultSet rs = null;
 try {
 conn = getConnection();
 pstmt = conn.prepareStatement(sql);
 rs = pstmt.executeQuery(); List<Member> members = new ArrayList<>();
 while(rs.next()) {
 Member member = new Member();
 member.setId(rs.getLong("id"));
 member.setName(rs.getString("name"));
 members.add(member);
 }
 return members;
 } catch (Exception e) {
 throw new IllegalStateException(e);
 } finally {
 close(conn, pstmt, rs);
 }
 }
 @Override
 public Optional<Member> findByName(String name) {
 String sql = "select * from member where name = ?";
 Connection conn = null;
 PreparedStatement pstmt = null;
 ResultSet rs = null;
 try {
 conn = getConnection();
 pstmt = conn.prepareStatement(sql);
 pstmt.setString(1, name);
 rs = pstmt.executeQuery();
 if(rs.next()) {
 Member member = new Member();
 member.setId(rs.getLong("id"));
 member.setName(rs.getString("name"));
 return Optional.of(member);
 } return Optional.empty();
 } catch (Exception e) {
 throw new IllegalStateException(e);
 } finally {
 close(conn, pstmt, rs);
 }
 }
 private Connection getConnection() {
 return DataSourceUtils.getConnection(dataSource);
 }
 private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
{
 try {
 if (rs != null) {
 rs.close();
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 try {
 if (pstmt != null) {
 pstmt.close();
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 try {
 if (conn != null) {
 close(conn);
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 private void close(Connection conn) throws SQLException {
 DataSourceUtils.releaseConnection(conn, dataSource); }
}
```

#### 참고
[인프런 영한님 강의](https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8&unitId=49594&category=chatDetail&tab=curriculum)
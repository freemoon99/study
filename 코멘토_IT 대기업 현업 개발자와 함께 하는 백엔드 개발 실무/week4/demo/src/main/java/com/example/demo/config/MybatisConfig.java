package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.example.demo.dao")
public class MybatisConfig {

  @Bean
  public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

    sqlSessionFactory.setDataSource(dataSource);
    sqlSessionFactory.setTypeAliasesPackage("com.example.demo.dto");

    // Mapper XML 파일의 위치 설정
    sqlSessionFactory.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath:com/example/demo/dao/*.xml")
    );

    return sqlSessionFactory.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {

    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
package org.donghyun.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@Configuration
@Log4j
public class CommonConfig {

	// ���� Ȯ��
	@Bean
	public String sample() {
		log.info("sample...........");
		return "Common";
	}
	
	// dataSource ����
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC");
		hikariConfig.setUsername("springuser");
		hikariConfig.setPassword("springuser");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean session = new SqlSessionFactoryBean();
		session.setDataSource(dataSource());
		
		return session.getObject();
	}
	
}

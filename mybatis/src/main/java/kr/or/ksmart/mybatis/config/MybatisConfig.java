package kr.or.ksmart.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration
@MapperScan(value="kr.or.ksmart.mybatis")
*/
public class MybatisConfig {

	/*@Bean(name = "mybatissqlSessionFactory")*/
	public SqlSessionFactory mybatisSqlSessionFactory
	(DataSource datasource, ApplicationContext context) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setMapperLocations(context.getResources("classpath:mapper/**/*.xml"));
		bean.setDataSource(datasource);
		
		return bean.getObject();
	}
}

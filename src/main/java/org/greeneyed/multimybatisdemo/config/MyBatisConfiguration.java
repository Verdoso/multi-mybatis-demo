package org.greeneyed.multimybatisdemo.config;

import javax.inject.Named;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.greeneyed.multimybatisdemo.mappers.AnotherMapper;
import org.greeneyed.multimybatisdemo.mappers.OneMapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyBatisConfiguration {
	private static final String ONE_SESSION_FACTORY = "oneSessionFactory";
	private static final String ANOTHER_SESSION_FACTORY = "anotherSessionFactory";

	@Bean(name = ONE_SESSION_FACTORY, destroyMethod = "")
	@Primary
	public SqlSessionFactoryBean sqlSessionFactory(@Named(DatabaseConfiguration.ONE_DATASOURCE) final DataSource oneDataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(oneDataSource);
		SqlSessionFactory sqlSessionFactory;
		sqlSessionFactory = sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getConfiguration().addMapper(OneMapper.class);
		// Various other SqlSessionFactory settings
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperFactoryBean<OneMapper> etrMapper(@Named(ONE_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
		MapperFactoryBean<OneMapper> factoryBean = new MapperFactoryBean<>(OneMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
		return factoryBean;
	}

	@Bean(name = ANOTHER_SESSION_FACTORY, destroyMethod = "")
	public SqlSessionFactoryBean censoSqlSessionFactory(@Named(DatabaseConfiguration.ANOTHER_DATASOURCE) final DataSource anotherDataSource)
	        throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(anotherDataSource);
		final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getConfiguration().addMapper(AnotherMapper.class);
		// Various other SqlSessionFactory settings
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperFactoryBean<AnotherMapper> dbMapper(@Named(ANOTHER_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean)
	        throws Exception {
		MapperFactoryBean<AnotherMapper> factoryBean = new MapperFactoryBean<>(AnotherMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
		return factoryBean;
	}
}
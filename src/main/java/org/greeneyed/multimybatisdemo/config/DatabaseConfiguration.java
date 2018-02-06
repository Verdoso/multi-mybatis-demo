package org.greeneyed.multimybatisdemo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {
	public static final String ONE_DATASOURCE = "OneDS";
	public static final String ANOTHER_DATASOURCE = "AnotherDS";

	@Bean(name = ONE_DATASOURCE, destroyMethod = "")
	@ConfigurationProperties(prefix = "datasources.one")
	@Primary
	public DataSource dataSourceOne() {
		// Filled up with the properties specified about thanks to Spring Boot black
		// magic
		return new HikariDataSource();
	}

	@Bean(name = ANOTHER_DATASOURCE, destroyMethod = "")
	@ConfigurationProperties(prefix = "datasources.another")
	public DataSource dataSourceAnother() {
		// Filled up with the properties specified about thanks to Spring Boot black
		// magic
		return new HikariDataSource();
	}
}

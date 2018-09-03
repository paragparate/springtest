package com.parag.test.jdbc03;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class DbConfig {

	DataSource dataSource;
	
	@Value("${jdbc.driverClass}")
	String driverClass;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	
	public DataSource getDataSource() {
		return (dataSource != null ? dataSource : createDataSource());
	}
	
	@SuppressWarnings("unchecked")
	private DataSource createDataSource() {
		
		try {
			SimpleDriverDataSource ds = new SimpleDriverDataSource();
			ds.setDriverClass((Class<? extends Driver>)Class.forName(driverClass));
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			this.dataSource = ds;
			return this.dataSource;
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return null;
		}		
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}	
}

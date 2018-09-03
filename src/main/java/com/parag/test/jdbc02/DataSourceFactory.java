package com.parag.test.jdbc02;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

@Component("dsFactory")
public class DataSourceFactory {

	DataSource ds;
	
	@Value("${jdbc.driverClass}")
	String driverClass;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	
	public DataSource getDataSource() {
		if (ds == null) 
			return createDataSource();
		else return ds;
	}
	
	@SuppressWarnings("unchecked")
	private DataSource createDataSource() {	
		try {
			SimpleDriverDataSource simpleDS = new SimpleDriverDataSource();
			simpleDS.setDriverClass((Class<? extends Driver>)(Class.forName(driverClass)));
			simpleDS.setUrl(url);
			simpleDS.setUsername(username);
			simpleDS.setPassword(password);
			return simpleDS;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
	
	
}

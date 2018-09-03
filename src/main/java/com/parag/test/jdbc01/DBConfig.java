package com.parag.test.jdbc01;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DBConfig {

	@Value("${jdbc.driverClass}")
	String driverClass;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
		DBConfig jdbc = (DBConfig) ctx.getBean("DBConfig");
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println(jdbc.username);
		System.out.println(dataSource);
		
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from student");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1) + " ");
			System.out.print(rs.getString(2) + " ");
			System.out.print(rs.getString(3) + " ");
			System.out.print(rs.getString(4) + " ");
			System.out.println();
		}
		stmt.close();
		conn.close();		
	}
	
	@SuppressWarnings("unchecked")
	@Bean
	@Lazy
	public DataSource dataSource() {
		try {
			SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
			Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClass);
			dataSource.setDriverClass(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			
			return dataSource;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}

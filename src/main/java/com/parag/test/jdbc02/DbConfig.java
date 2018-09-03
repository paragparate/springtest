package com.parag.test.jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Configuration
@ComponentScan(basePackages= {"com.parag.test.jdbc02"})
@PropertySource("classpath:application.properties")
public class DbConfig {
	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class, DataSourceFactory.class);
		DataSourceFactory dsFactory = ctx.getBean("dsFactory", DataSourceFactory.class);

		DataSource ds = dsFactory.getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		
		String sql = "select * from student where id > ?";
		Object[] arguments = new Object[] {4};
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper(), arguments);
		for (Student student : students) {
			System.out.println(student);
		}		
	}
	
	private static class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt(1));
			student.setFirstName(rs.getString(2));
			student.setLastName(rs.getString(3));
			student.setEmail(rs.getString(4));
			return student;
		}
		
	}
}

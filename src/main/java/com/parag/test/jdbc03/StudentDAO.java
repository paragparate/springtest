package com.parag.test.jdbc03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.parag.test.jdbc03.Student;

@Component
public class StudentDAO {
	
	@Autowired
	DbConfig config;
	StudentInsert studentInsert;
	
	public Student findById(int id) {
		studentInsert = new StudentInsert(config.getDataSource());
		JdbcTemplate template = config.getJdbcTemplate();
		String sql = "select * from student where id = ?";
		Object[] args = new Object[]{id};
		List<Student> students = template.query(sql, args, new StudentMapper());
		return students.get(0);
	}
	
	
	public void insert(Student student) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", student.getFirstName());
		map.put("lastName", student.getLastName());
		map.put("email", student.getEmail());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		studentInsert.updateByNamedParam(map, keyHolder);
		student.setId(keyHolder.getKey().intValue());
		System.out.println("new student id "+student.getId());
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

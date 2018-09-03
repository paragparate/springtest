package com.parag.test.jdbc03;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class StudentInsert extends SqlUpdate {

	private static final String INSERT_SQL = "insert into student (first_name, last_name, email) "
			+ "values (:firstName, :lastName, :email)";
	
	public StudentInsert(DataSource dataSource) {
		super(dataSource, INSERT_SQL);
		super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
		super.declareParameter(new SqlParameter("lastName", Types.VARCHAR));
		super.declareParameter(new SqlParameter("email", Types.VARCHAR));
		super.setGeneratedKeysColumnNames("id");
		super.setReturnGeneratedKeys(true);
	}
}

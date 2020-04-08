package com.sv.xmltodatabase.config;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.sv.xmltodatabase.model.Student;

public class Studentpreparedstatement implements ItemPreparedStatementSetter<Student> {

	@Override
	public void setValues(Student student, PreparedStatement ps) throws SQLException {
		ps.setInt(1, student.getStudentId());
		ps.setString(2, student.getFirstName());
		ps.setString(3, student.getLastName());
		ps.setString(4, student.getEmail());
		ps.setInt(5, student.getAge());
	}

}

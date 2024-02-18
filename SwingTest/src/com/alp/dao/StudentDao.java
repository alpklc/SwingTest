package com.alp.dao;

import java.sql.SQLException;
import java.util.List;

import com.alp.model.Student;

public interface StudentDao {

	int add(Student student) throws SQLException;
	void delete(int id) throws SQLException;
	Student getStudent(int id) throws SQLException;
	List<Student> getStudents() throws SQLException;
	void update(Student student) throws SQLException;
}

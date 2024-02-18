package com.alp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alp.model.Student;
import com.alp.util.DatabaseConnection;

public class StudentDaoImpl implements StudentDao {
	
	static Connection conn = DatabaseConnection.getInstance().getConnection();

	@Override
	public int add(Student student) throws SQLException {
		String query = "INSERT INTO student.student(name, surname, number) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, student.getName());
		statement.setString(2, student.getSurname());
		statement.setString(3, student.getNumber());
		
		statement.addBatch();
		
		return statement.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		String query = "DELETE FROM student.student WHERE id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		statement.executeUpdate();
	}

	@Override
	public Student getStudent(int id) throws SQLException {
		String query = "SELECT * FROM student.student id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		
		Student student = null;
		ResultSet rs = statement.executeQuery();
		boolean check = false;
		
		while (rs.next()) {
			check = true;
			student = new Student(
					rs.getString("name"), 
					rs.getString("surname"), 
					rs.getString("number"));
		}
		
		if (check == true)
			return student;
		else
			return null;
	}

	@Override
	public List<Student> getStudents() throws SQLException {
		String query = "SELECT * FROM student.student";
		
		PreparedStatement statement = conn.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		List<Student> students = new ArrayList<Student>();
		
		while (rs.next()){
			Student student = new Student(
					rs.getString("name"),
					rs.getString("surname"),
					rs.getString("number"));
			students.add(student);
		}
		return students;
	}

	@Override
	public void update(Student student) throws SQLException {
		String query = "UPDATE student.student " + 
					"SET name = ?, surname = ?, number = ? " +
					"WHERE id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, student.getName());
		statement.setString(2, student.getSurname());
		statement.setString(3, student.getNumber());
		
		statement.executeUpdate();
	}

}

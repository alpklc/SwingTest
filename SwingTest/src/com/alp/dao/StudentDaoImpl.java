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
	public Student get(int id) throws SQLException {
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
	public List<Student> getAll() throws SQLException {
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
	public int save(Student t) throws SQLException {
		String query = "INSERT INTO student.student(name, surname, number) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, t.getName());
		statement.setString(2, t.getSurname());
		statement.setString(3, t.getNumber());
		
		statement.addBatch();
		
		return statement.executeUpdate();
	}

	@Override
	public void update(Student t) throws SQLException {
		String query = "UPDATE student.student " + 
				"SET name = ?, surname = ?, number = ? " +
				"WHERE id = ?";
	
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, t.getName());
		statement.setString(2, t.getSurname());
		statement.setString(3, t.getNumber());
		
		statement.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		String query = "DELETE FROM student.student WHERE id = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		statement.executeUpdate();
	}
	


}

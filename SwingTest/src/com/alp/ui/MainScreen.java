package com.alp.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.alp.dao.Dao;
import com.alp.dao.StudentDaoImpl;
import com.alp.model.Student;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainScreen() {
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 10, 60, 25);
		
		JTextField nameField = new JTextField();
		nameField.setBounds(80, 10, 200, 25);
		
		JLabel surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(10, 50, 60, 25);
		
		JTextField surnameField = new JTextField();
		surnameField.setBounds(80, 50, 200, 25);
		
		JLabel numberLabel = new JLabel("Number");
		numberLabel.setBounds(10, 90, 60, 25);
		
		JTextField numberField = new JTextField();
		numberField.setBounds(80, 90, 200, 25);
				
		JButton addButton = new JButton("Add");
		addButton.setBounds(80, 140, 100, 40);
		
		JLabel infoLabel = new JLabel("");
		infoLabel.setBounds(10, 190, 150, 25);
		
		this.setTitle("Application");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(420, 420);
		this.setLayout(null);
		this.setVisible(true);
		
		this.add(nameLabel);
		this.add(nameField);
		this.add(surnameLabel);
		this.add(surnameField);
		this.add(numberLabel);
		this.add(numberField);
		this.add(addButton);
		this.add(infoLabel);
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student(nameField.getText(), surnameField.getText(), numberField.getText());
				System.out.println(s);

				Dao<Student> studentDao = new StudentDaoImpl();
				
				try {
					studentDao.save(s);
					infoLabel.setText("Added record to database.");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
	}
}

package org.ninthgang.time.service;

import java.util.List;

import org.ninthgang.time.domain.Student;

public interface StudentService {
	public void addNewStudent(Student stu);

	public void deleteStudent(String stuName);
	
	public Student getStudent(String stuName);
	
	public List<Student> getAllStudent();
}

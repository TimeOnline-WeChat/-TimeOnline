/**
 * 
 */
package org.ninthgang.time.service;

import java.util.List;

import org.ninthgang.time.dao.StudentDao;
import org.ninthgang.time.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 圆梦助学学生信息服务类
 * 
 * @author lingqiusang
 *
 */
@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public void addNewStudent(Student stu){
		studentDao.saveStudent(stu);
	}

	public void deleteStudent(String stuName){
		studentDao.deleteStudentByName(stuName);
	}

	public Student getStudent(String stuName){
		Student student = studentDao.getStuByName(stuName);
		return student;
	}
	
	public List<Student> getAllStudent(){
		List<Student> students = studentDao.findAllStu();
		return students;
		
	}
}

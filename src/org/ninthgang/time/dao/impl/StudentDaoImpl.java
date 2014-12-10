package org.ninthgang.time.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ninthgang.time.dao.StudentDao;
import org.ninthgang.time.domain.FTutor;
import org.ninthgang.time.domain.Student;
import org.ninthgang.time.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author lhy
 *
 */
@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStudent(Student stu) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(stu);
		session.flush();
		session.close();
		
	}

	@Override
	public void deleteStudentByName(String stuName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery(
					" delete Student stu where stu.stuName=:stuName ").setString(
					"stuName", stuName);
			q.executeUpdate();
			session.flush();
		} catch (Exception e) {
		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public Student getStuByName(String stuName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery(
				" from Student stu where stu.stuName=:stuName ").setString(
				"stuName", stuName);
		List<Student> stu = (List<Student>) q.list();// 返回一个对象集合
		Student student = null;
		if (stu.size() > 0) {
			student = stu.get(0);
		}
		return student;
	}

	@Override
	public List<Student> findAllStu() {
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery(" from Student ");
		List<Student> students = new ArrayList<Student>();
		students = (List<Student>) q.list();
		return students;
		
	}

}

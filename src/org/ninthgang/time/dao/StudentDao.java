package org.ninthgang.time.dao;

import org.ninthgang.time.domain.Student;


/**
 * 学生信息数据库操作类
 * @author lhy
 *
 */
public interface StudentDao {
	
	/**
	 * 保存学生信息
	 */
	public void saveStudent(Student stu);
	/**
	 * 删除学生信息
	 */
	public void deleteStudent(String stuName);
	/**
	 * 获取学生信息
	 */
	public Student getStuByName(String stuName);

}

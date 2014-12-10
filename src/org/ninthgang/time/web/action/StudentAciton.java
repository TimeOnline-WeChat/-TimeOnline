/**
 * 
 */
package org.ninthgang.time.web.action;

import org.ninthgang.time.domain.Student;
import org.ninthgang.time.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author lingqiusang
 *
 */
public class StudentAciton extends ActionSupport implements ModelDriven<Student>{

	/**
	 * 2014年12月10日
	 */
	private static final long serialVersionUID = -357829319630003845L;

	private Student student = new Student();
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public Student getModel() {
		System.out.println("");
		return student;
	}
	
	public String execute () throws Exception{
		studentService.addNewStudent(student);
		return "success";
	}

}

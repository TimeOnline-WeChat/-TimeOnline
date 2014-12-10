/**
 * 
 */
package org.ninthgang.time.web.action;

import org.ninthgang.time.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author lingqiusang
 *
 */
public class StudentAciton extends ActionSupport implements ModelDriven<Student>{

	private Student student = new Student();
	
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	
	public String execute () throws Exception{
		System.out.println("=================="+student.getStuName());
		System.out.println("=================="+student.getStuAddress());
		System.out.println("=================="+student.getStuContent());
		System.out.println("=================="+student.getStuGrade());
		System.out.println("=================="+student.getStuNote());
		System.out.println("=================="+student.getStuSex());
		System.out.println("=================="+student.getStuTel());
		return "success";
	}

}

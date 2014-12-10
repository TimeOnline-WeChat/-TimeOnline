/**
 * 
 */
package org.ninthgang.time.web.action;

import org.ninthgang.time.domain.Help;
import org.ninthgang.time.domain.Student;
import org.ninthgang.time.domain.Tutor;
import org.ninthgang.time.domain.User;
import org.ninthgang.time.service.FTutorService;
import org.ninthgang.time.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author lingqiusang
 *
 */
public class FTutorAciton extends ActionSupport implements ModelDriven<Tutor>{

	private Tutor tutor=new Tutor();
	@Autowired
	private FTutorService fTutorService;

	public String execute () throws Exception{
//		System.out.println("======"+tutor.getTuName());
//		//studentService.addNewStudent(student);
		fTutorService.addNewFTutor(tutor);
		return "success";
	}


	@Override
	public Tutor getModel() {
		// TODO Auto-generated method stub
		return tutor;
	}




}

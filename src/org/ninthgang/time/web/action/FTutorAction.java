/**
 * 
 */
package org.ninthgang.time.web.action;

import org.ninthgang.time.domain.FTutor;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author lingqiusang
 *
 */
public class FTutorAction extends ActionSupport implements ModelDriven<FTutor>{

	private FTutor fTutor = new FTutor();
	
	@Override
	public FTutor getModel() {
		return fTutor;
	}
	
}

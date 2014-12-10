package org.ninthgang.time.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 家教学生信息类
 * 
 * @author lhy
 *
 */

@Entity
@Table(name = "t_fTutor")
public class Tutor {
	/**
	 * 自增长ID
	 */
	private int tuID;
	/**
	 * 姓名
	 */
	private String tuName;
	/**
	 * 学员性别
	 */
	private String tuSex;
	/**
	 * 学员年级
	 */
	private String tuGrade;
	/**
	 * 辅导科目
	 */
	private String tuCourse;
	/**
	 * 学习情况
	 */
	private String tuState;
	/**
	 * 辅导方式
	 */
	private String tuMethod;
	/**
	 * 家教时间
	 */
	private String tuTime;
	/**
	 * 联系方式
	 */
	private String tuTel;
	/**
	 * 住址
	 */
	private String tuAddress;
	/**
	 * 对老师的要求
	 */
	private String tuRequest;
	
	@Id
	@GeneratedValue
	public int getTuID() {
		return tuID;
	}
	public void setTuID(int tuID) {
		this.tuID = tuID;
	}
	public String getTuName() {
		return tuName;
	}
	public void setTuName(String tuName) {
		this.tuName = tuName;
	}
	public String getTuSex() {
		return tuSex;
	}
	public void setTuSex(String tuSex) {
		this.tuSex = tuSex;
	}
	public String getTuGrade() {
		return tuGrade;
	}
	public void setTuGrade(String tuGrade) {
		this.tuGrade = tuGrade;
	}
	public String getTuCourse() {
		return tuCourse;
	}
	public void setTuCourse(String tuCourse) {
		this.tuCourse = tuCourse;
	}
	public String getTuState() {
		return tuState;
	}
	public void setTuState(String tuState) {
		this.tuState = tuState;
	}
	public String getTuMethod() {
		return tuMethod;
	}
	public void setTuMethod(String tuMethod) {
		this.tuMethod = tuMethod;
	}
	public String getTuTime() {
		return tuTime;
	}
	public void setTuTime(String tuTime) {
		this.tuTime = tuTime;
	}
	public String getTuTel() {
		return tuTel;
	}
	public void setTuTel(String tuTel) {
		this.tuTel = tuTel;
	}
	public String getTuAddress() {
		return tuAddress;
	}
	public void setTuAddress(String tuAddress) {
		this.tuAddress = tuAddress;
	}
	public String getTuRequest() {
		return tuRequest;
	}
	public void setTuRequest(String tuRequest) {
		this.tuRequest = tuRequest;
	}
	
	
	

	

	
}

package org.ninthgang.time.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 学生信息类
 * @author lhy
 *
 */

@Entity
@Table(name = "t_student")
public class Student {
	
	/** 自增长id */
	private int stuID;
	/**
	 * 学生姓名
	 */
	private String stuName;
	/**
	 * 学生性别
	 */
	private String stuSex;
	/**
	 * 学生年级
	 */
	private String stuGrade;
	/**
	 * 联系方式
	 */
	private String stuTel;
	/**
	 * 住址
	 */
	private String stuAddress;
	/**
	 * 补习内容
	 */
	private String stuContent;
	/**
	 * 备注
	 */
	private String stuNote;
	
	@Id
	@GeneratedValue
	
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	public String getStuTel() {
		return stuTel;
	}
	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuContent() {
		return stuContent;
	}
	public void setStuContent(String stuContent) {
		this.stuContent = stuContent;
	}
	public String getStuNote() {
		return stuNote;
	}
	public void setStuNote(String stuNote) {
		this.stuNote = stuNote;
	}
	
	

}

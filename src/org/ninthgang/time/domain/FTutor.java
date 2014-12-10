package org.ninthgang.time.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 找家教学生信息类
 * 
 * @author lhy
 *
 */

@Entity
@Table(name = "t_fTutor")
public class FTutor {
	/**
	 * 自增长ID
	 */
	private int sID;
	/**
	 * 姓名
	 */
	private String sName;
	/**
	 * 学员性别
	 */
	private String sSex;
	/**
	 * 学员年级
	 */
	private String sGrade;
	/**
	 * 辅导科目
	 */
	private String sCourse;
	/**
	 * 学习情况
	 */
	private String sState;
	/**
	 * 辅导方式
	 */
	private String sMethod;
	/**
	 * 家教时间
	 */
	private String sTime;
	/**
	 * 联系方式
	 */
	private String sTel;
	/**
	 * 住址
	 */
	private String sAddress;
	/**
	 * 对老师的要求
	 */
	private String sRequest;
	
	@Id
	@GeneratedValue
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsSex() {
		return sSex;
	}
	public void setsSex(String sSex) {
		this.sSex = sSex;
	}
	public String getsGrade() {
		return sGrade;
	}
	public void setsGrade(String sGrade) {
		this.sGrade = sGrade;
	}
	public String getsCourse() {
		return sCourse;
	}
	public void setsCourse(String sCourse) {
		this.sCourse = sCourse;
	}
	public String getsState() {
		return sState;
	}
	public void setsState(String sState) {
		this.sState = sState;
	}
	public String getsMethod() {
		return sMethod;
	}
	public void setsMethod(String sMethod) {
		this.sMethod = sMethod;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public String getsTel() {
		return sTel;
	}
	public void setsTel(String sTel) {
		this.sTel = sTel;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getsRequest() {
		return sRequest;
	}
	public void setsRequest(String sRequest) {
		this.sRequest = sRequest;
	}
	
}

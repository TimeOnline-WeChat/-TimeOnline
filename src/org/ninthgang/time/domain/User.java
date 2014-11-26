/**
 * 
 */
package org.ninthgang.time.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.ninthgang.time.util.MessTools;

/**
 * 用户类
 * 
 * @author lingqiusang
 * 
 */
@Entity
@Table(name = "t_user")
public class User {

	/** 自增长id */
	private int id;
	/** 用户名 */
	private String userName;

	/** 连续签到次数 */
	private int signInCount;

	/** 最近签到日期 */
	private String lastSignInDate;

	public User() {
		this.signInCount=1;
		this.lastSignInDate = MessTools.getCurrentDate();
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSignInCount() {
		return signInCount;
	}

	public void setSignInCount(int signInCount) {
		this.signInCount = signInCount;
	}
	public String getLastSignInDate() {
		return lastSignInDate;
	}
	public void setLastSignInDate(String lastSignInDate) {
		this.lastSignInDate = lastSignInDate;
	}



}

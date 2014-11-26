/**
 * 
 */
package org.ninthgang.time.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lingqiusang
 *
 */
@Entity
@Table(name="t_user")
public class User {
	
	/** 自增长id*/
	private int id;
	/** 用户名*/
	private String username;
	
	/** 连续签到次数*/
	private String signInCount;
	
	/** 最近签到日期*/
	private Date lastSignInDate;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSignInCount() {
		return signInCount;
	}

	public void setSignInCount(String signInCount) {
		this.signInCount = signInCount;
	}

	public Date getLastSignInDate() {
		return lastSignInDate;
	}

	public void setLastSignInDate(Date lastSignInDate) {
		this.lastSignInDate = lastSignInDate;
	}	
	
}

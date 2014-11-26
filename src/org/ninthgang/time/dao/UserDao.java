/**
 * 
 */
package org.ninthgang.time.dao;

import org.ninthgang.time.domain.User;

/**
 * @author lingqiusang
 *
 */
public interface UserDao {
	/** 保存用户*/
	public void saveUser(User user);
	/** 删除用户*/
	public void deleteUser(String userName);
	/** 根据用户名获取用户*/
	public User getUserByUserName(String userName);
	/** 更新用户签到信息*/
	public void updateSignInCount(User user);
}

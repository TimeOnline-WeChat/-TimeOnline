/**
 * 
 */
package org.ninthgang.time.dao;

import org.ninthgang.time.domain.User;

/**
 * 用户数据库操作类
 * 
 * @author lingqiusang
 * 
 */
public interface UserDao {
	
	/** 保存用户 */
	public void saveUser(User user);

	/** 删除用户 */
	public void deleteUser(String userName);

	/** 根据用户名获取用户 */
	public User getUserByUserName(String userName);

	/** 更新用户信息 */
	public void updateSignInCount(User user);

	/** 用户签到天数加一 */
	public void addSignInCount(String userName);

	/** 用户签到天数清为1 */
	public void setSignInCountTo1(String userName);
}

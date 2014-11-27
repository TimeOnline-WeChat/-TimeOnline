/**
 * 
 */
package org.ninthgang.time.service;

import org.ninthgang.time.dao.UserDao;
import org.ninthgang.time.domain.User;
import org.ninthgang.time.util.MessTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lingqiusang
 * 
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	/** 添加新用户 */
	public void addNewUser(String userName) {
		if (userDao.getUserByUserName(userName) == null) {
			User user = new User();
			user.setUserName(userName);
			userDao.saveUser(user);
		}
	}

	/** 用户签到 */
	public int signIn(String userName) {
		User user = userDao.getUserByUserName(userName);
		String signInDate = user.getLastSignInDate();
		if (user != null) {	
			if (signInDate.equals(MessTools.getCurrentDate())) {// 当天已经签到
				return 0;
			} else {
				if (signInDate.equals(MessTools.getYesterday())) { // 属于连续签到
					userDao.addSignInCount(userName);
					return 2;
				} else { // 属于非连续签到
					userDao.setSignInCountTo1(userName);
					return 1;
				}
			}
		}
		return -1;	// 签到失败
	}
	/** 获取签到次数 */
	public int getSignInCount(String userName){
		User user = userDao.getUserByUserName(userName);
		if(user!=null){
			return user.getSignInCount();
		}
		return -1;
	}
}

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
	public String signIn(String userName) {
		User user = userDao.getUserByUserName(userName);
		String signInDate = user.getLastSignInDate();
		int signInCount = getSignInCount(userName);
		if (user != null && signInCount!=-1) {	
			if (signInDate.equals(MessTools.getCurrentDate())) {// 当天已经签到
				
				return "今天已经签到过了哦，请明天再来哦！\n目前连续签到天数:"+signInCount+"天。";
				
			} else {
				if (signInDate.equals(MessTools.getYesterday())) { // 属于连续签到
					userDao.addSignInCount(userName);
					return "今天签到成功,请明天再来哦！\n目前连续签到天数:"+(signInCount+1)+"天。";
				} else { // 属于非连续签到
					userDao.setSignInCountTo1(userName);
					return "今天签到成功,但是没有保持连续签到哦！\n目前连续签到天数："+1+"天。";
				}
			}
		}
		return "签到失败";	// 签到失败
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

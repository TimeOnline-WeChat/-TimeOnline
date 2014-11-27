/**
 * 
 */
package org.ninthgang.time.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ninthgang.time.dao.UserDao;
import org.ninthgang.time.domain.User;
import org.ninthgang.time.util.MessTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lingqiusang
 * 
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.flush();
		session.close();
	}

	@Override
	public void deleteUser(String userName) {
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery(
					" delete User t where t.userName=:userName ").setString(
					"userName", userName);
			q.executeUpdate();
			session.flush();
		} catch (Exception e) {
		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public User getUserByUserName(String userName) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery(
				" from User t where t.userName=:userName ").setString(
				"userName", userName);
		List<User> users = (List<User>) q.list();// 返回一个对象集合
		User user = null;
		if (users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}

	@Override
	public void updateSignInCount(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.update(user);
		} catch (Exception e) {

		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public void addSignInCount(String userName) {
		User user = getUserByUserName(userName);
		user.setSignInCount(user.getSignInCount() + 1);
		user.setLastSignInDate(MessTools.getCurrentDate());
		updateSignInCount(user);
	}

	@Override
	public void setSignInCountTo1(String userName) {
		User user = getUserByUserName(userName);
		user.setSignInCount(1);
		user.setLastSignInDate(MessTools.getCurrentDate());
		updateSignInCount(user);
	}

}

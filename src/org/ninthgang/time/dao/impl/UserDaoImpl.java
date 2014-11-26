/**
 * 
 */
package org.ninthgang.time.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ninthgang.time.dao.UserDao;
import org.ninthgang.time.domain.User;
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
	/* (non-Javadoc)
	 * @see org.ninthgang.time.dao.UserDao#saveUser(org.ninthgang.time.domain.User)
	 */
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.flush();
		session.close();
	}

	/* (non-Javadoc)
	 * @see org.ninthgang.time.dao.UserDao#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.ninthgang.time.dao.UserDao#getUserByUserName(java.lang.String)
	 */
	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.ninthgang.time.dao.UserDao#updateSignInCount(org.ninthgang.time.domain.User)
	 */
	@Override
	public void updateSignInCount(User user) {
		// TODO Auto-generated method stub

	}

}

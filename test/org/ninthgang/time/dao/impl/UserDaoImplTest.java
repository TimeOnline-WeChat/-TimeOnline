package org.ninthgang.time.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ninthgang.time.dao.UserDao;
import org.ninthgang.time.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSaveUser() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = new User();
		user.setLastSignInDate(new Date());
		user.setSignInCount("1");
		user.setUsername("你好");
		userDao.saveUser(user);
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSignInCount() {
		fail("Not yet implemented");
	}

}

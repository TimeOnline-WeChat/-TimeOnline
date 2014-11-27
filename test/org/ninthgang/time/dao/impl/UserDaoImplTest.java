package org.ninthgang.time.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import javax.print.attribute.standard.Media;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ninthgang.time.dao.UserDao;
import org.ninthgang.time.domain.User;
import org.ninthgang.time.util.MessTools;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
		user.setLastSignInDate(MessTools.getCurrentDate());
		user.setSignInCount(1);
		user.setUserName("你好");
		userDao.saveUser(user);
	}

	@Test
	public void testDeleteUser() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		userDao.deleteUser("wx8e0ffe8761f2c036");
	}

	@Test
	public void testGetUserByUserName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = userDao.getUserByUserName("你好");
		System.out.println(user.getId());
	}

	@Test
	public void testUpdateSignInCount() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = userDao.getUserByUserName("你好");
		user.setSignInCount(2);
		userDao.updateSignInCount(user);
	}

	@Test
	public void testAddSignInCount() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		userDao.addSignInCount("你好");
	}
	@Test
	public void testSetSignInCountTo1() {
		//BeanFactory factory = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		userDao.setSignInCountTo1("123");
		System.out.println(MessTools.getYesterday());
	}
	
}

package org.ninthgang.time.dao.impl;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ninthgang.time.service.UserService;

public class UserServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		UserService userService = new UserService();
		int n=userService.getSignInCount("你好");
		System.out.println(n);
	}

}

package com.cee.sjm.user;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cee.sjm.user.User;
import com.cee.sjm.user.UserDao;
import com.cee.sjm.user.UserMybatisDao;

public class UserMybatisDaoTest {

	private static UserDao userDao;

	@BeforeClass
	public static void initialize() {
		userDao = new UserMybatisDao();
	}

	@Test
	public void testGetAll() {
		List<User> users = userDao.getAll();

		Assert.assertTrue(users != null && users.size() > 0);
	}
}

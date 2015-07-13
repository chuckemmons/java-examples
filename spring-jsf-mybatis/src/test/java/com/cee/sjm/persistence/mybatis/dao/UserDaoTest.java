package com.cee.sjm.persistence.mybatis.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cee.sjm.domain.User;
import com.cee.sjm.persistence.dao.UserDao;

public class UserDaoTest {

	private static UserDao userDao;

	@BeforeClass
	public static void initialize() {
		userDao = new UserDaoImpl();
	}

	@Test
	public void testGetAll() {
		List<User> users = userDao.getAll();

		Assert.assertTrue(users != null && users.size() > 0);
	}
}

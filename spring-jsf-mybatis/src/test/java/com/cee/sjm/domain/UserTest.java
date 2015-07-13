package com.cee.sjm.domain;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void testNotEqualDifferentIds() {
		User user1 = new User();
		user1.setId(0);
		user1.setName("name");
		User user2 = new User();
		user2.setId(1);
		user2.setName("name");

		Assert.assertFalse(user1.equals(user2));
	}

	@Test
	public void testNotEqualDifferentNames() {
		User user1 = new User();
		user1.setId(0);
		user1.setName("name1");
		User user2 = new User();
		user2.setId(0);
		user2.setName("name2");

		Assert.assertFalse(user1.equals(user2));
	}

	@Test
	public void testEqualSameProperties() {
		User user1 = new User();
		user1.setId(0);
		user1.setName("name");
		User user2 = new User();
		user2.setId(0);
		user2.setName("name");

		Assert.assertTrue(user1.equals(user2));
	}

	@Test
	public void testEqualDifferentNewObjects() {
		User user1 = new User();
		User user2 = new User();
		Assert.assertTrue(user1.equals(user2));
	}

	@Test
	public void testEqualSameObject() {
		User user1 = new User();
		User user2 = user1;
		Assert.assertTrue(user1.equals(user2));
	}
}

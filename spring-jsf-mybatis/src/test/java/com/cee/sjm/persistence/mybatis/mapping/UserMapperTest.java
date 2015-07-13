package com.cee.sjm.persistence.mybatis.mapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cee.sjm.domain.User;
import com.cee.sjm.persistence.mybatis.mapping.UserMapper;

public class UserMapperTest {

	private static SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	private UserMapper mapper;

	// do not persist. note: sequence number in database will be
	// auto-incremented for id.
	private static final boolean AUTO_COMMIT = false;
	private static final Log LOG = LogFactory.getLog(UserMapperTest.class);

	@BeforeClass
	public static void initialize() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException ioe) {
			LOG.error(
					"Unable to create input stream for resource: " + resource,
					ioe);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Before
	public void beforeTestMethods() {
		session = sqlSessionFactory.openSession(AUTO_COMMIT);
		mapper = session.getMapper(UserMapper.class);
	}

	@After
	public void afterTestMethods() {
		session.close();
	}

	@Test
	public void testSave() {
		String name = "blah";

		User user = new User();
		user.setName(name);

		mapper.save(user);

		User savedUser = mapper.getByName(name);
		LOG.info(savedUser);

		Assert.assertNotNull(savedUser);
	}

	@Test
	public void testGetAll() {
		List<User> users = mapper.getAll();

		for (User user : users) {
			LOG.info(user.toString()); // todo change log to debug
		}

		Assert.assertTrue(users != null && users.size() > 0);
	}

}

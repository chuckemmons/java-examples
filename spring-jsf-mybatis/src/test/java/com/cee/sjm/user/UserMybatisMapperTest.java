package com.cee.sjm.user;

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

public class UserMybatisMapperTest {

	private static SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	private UserMybatisMapper mapper;

	// do not persist. note: sequence number in database will be
	// auto-incremented for id.
	private static final String MYBATIS_CONFIG_FILE_PATH = "config/mybatis-config.xml";
	private static final boolean AUTO_COMMIT = false;
	private static final Log LOG = LogFactory
			.getLog(UserMybatisMapperTest.class);

	@BeforeClass
	public static void initialize() {
		InputStream inputStream = null;
		try {
			inputStream = Resources
					.getResourceAsStream(MYBATIS_CONFIG_FILE_PATH);
		} catch (IOException ioe) {
			LOG.error("Unable to create input stream for resource: "
					+ MYBATIS_CONFIG_FILE_PATH, ioe);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Before
	public void beforeTestMethods() {
		session = sqlSessionFactory.openSession(AUTO_COMMIT);
		mapper = session.getMapper(UserMybatisMapper.class);
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

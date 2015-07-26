package com.cee.sjm.framework.persistence.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {
	private static final Log LOG = LogFactory.getLog(SessionUtils.class);

	private static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		} catch (IOException ioe) {
			LOG.error(
					"Unable to create input stream for resource: " + resource,
					ioe);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				LOG.error("Unable to close input stream for resource: "
						+ resource, e);
			}
		}

	}

	private SessionUtils() {
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
}

package com.cee.sjm.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cee.sjm.framework.persistence.mybatis.util.SessionUtils;

public class UserMybatisDao implements UserDao {

	private static SqlSessionFactory sessionFactory;

	static {
		sessionFactory = SessionUtils.getSession();
	}

	@Override
	public List<User> getAll() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<User> users = null;
		try {
			UserMybatisMapper mapper = sqlSession.getMapper(UserMybatisMapper.class);
			users = mapper.getAll();
		} finally {
			sqlSession.close();
		}

		return users;
	}

	@Override
	public void save(User user) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			UserMybatisMapper mapper = sqlSession.getMapper(UserMybatisMapper.class);
			mapper.save(user);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void update(User user) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			UserMybatisMapper mapper = sqlSession.getMapper(UserMybatisMapper.class);
			mapper.update(user);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void delete(Integer id) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			UserMybatisMapper mapper = sqlSession.getMapper(UserMybatisMapper.class);
			mapper.delete(id);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public User getByName(String name) {
		SqlSession sqlSession = sessionFactory.openSession();
		User user = null;
		try {
			UserMybatisMapper mapper = sqlSession.getMapper(UserMybatisMapper.class);
			mapper.getByName(name);
		} finally {
			sqlSession.close();
		}
		return user;
	}

}

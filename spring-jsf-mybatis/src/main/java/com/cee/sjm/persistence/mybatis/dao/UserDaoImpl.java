package com.cee.sjm.persistence.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cee.sjm.domain.User;
import com.cee.sjm.persistence.dao.UserDao;
import com.cee.sjm.persistence.mybatis.mapping.UserMapper;
import com.cee.sjm.persistence.mybatis.util.SessionUtils;

public class UserDaoImpl implements UserDao {

	private static SqlSessionFactory sessionFactory;

	static {
		sessionFactory = SessionUtils.getSession();
	}

	@Override
	public List<User> getAll() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<User> users = null;
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
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
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.save(user);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void update(User user) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.update(user);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void delete(Integer id) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
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
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.getByName(name);
		} finally {
			sqlSession.close();
		}
		return user;
	}

}

package com.cee.sjm.persistence.dao;

import java.util.List;

import com.cee.sjm.domain.User;

public interface UserDao {

	public List<User> getAll();

	public void save(User user);

	public void update(User user);

	public void delete(Integer id);

	public User getByName(String name);
}

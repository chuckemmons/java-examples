package com.cee.sjm.user;

import java.util.List;

public interface UserDao {

	public List<User> getAll();

	public void save(User user);

	public void update(User user);

	public void delete(Integer id);

	public User getByName(String name);
}

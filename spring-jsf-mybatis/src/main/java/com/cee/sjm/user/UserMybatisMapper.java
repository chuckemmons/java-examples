package com.cee.sjm.user;

import java.util.List;

public interface UserMybatisMapper {

	public void save(User user);

	public void update(User user);

	public void delete(int id);

	public List<User> getAll();

	public User getByName(String name);
}

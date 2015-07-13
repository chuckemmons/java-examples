package com.cee.sjm.persistence.mybatis.mapping;

import java.util.List;

import com.cee.sjm.domain.User;

public interface UserMapper {

	public void save(User user);

	public void update(User user);

	public void delete(int id);

	public List<User> getAll();

	public User getByName(String name);
}

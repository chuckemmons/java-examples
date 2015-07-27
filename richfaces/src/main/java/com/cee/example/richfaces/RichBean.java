package com.cee.example.richfaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cee.example.richfaces.user.User;

@ViewScoped
@ManagedBean
public class RichBean implements Serializable {
	private static final long serialVersionUID = -6239437588285327644L;

	private String name;
	private List<User> users;

	public RichBean() {
		initialize();
	}

	@PostConstruct
	public void postContruct() {
		name = "John";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	private void initialize() {
		this.users = generateUsers();
	}

	private List<User> generateUsers() {
		List<User> users = new ArrayList<User>();
		for (int i = 1; i < 10; i++) {
			User user = new User();
			user.setId(i);
			user.setName("User_" + i);
			users.add(user);
		}
		return users;
	}
}
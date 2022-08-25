package com.novare.recipe.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserPool")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserPool {

	@XmlElement(name = "User")
	private List<User> userPool = new ArrayList<>();

	public UserPool() {
	}

	public List<User> getUsers() {
		return userPool;
	}

	public void addUser(User user) {
		this.userPool.add(user);
	}

	public void removeUser(User user) {
		this.userPool.remove(user);
	}

	@Override
	public String toString() {
		return "UserPool [userPool=" + userPool + "]";
	}

}

package com.novare.recipe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "name", "weekPlan" })
public class User {
	private int id;
	private String name;
	@XmlElementWrapper(name = "WeeklyPlans")
	@XmlElement(name = "WeekPlan")
	private List<WeekPlan> weekPlan = new ArrayList<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, List<WeekPlan> weekPlan) {
		super();
		this.id = id;
		this.name = name;
		this.weekPlan = weekPlan;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the weekPlan
	 */
	public List<WeekPlan> getWeekPlan() {
		return weekPlan;
	}

	/**
	 * @param weekPlan the weekPlan to set
	 */
	public void addWeekPlan(WeekPlan weekPlan) {
		this.weekPlan.add(weekPlan);
	}

	public void removeWeekPlan(WeekPlan weekPlan) {
		this.weekPlan.remove(weekPlan);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof String) {
			String name = (String) obj;
			return this.name.equals(name);
		}
		User user = (User) obj;
		return this.getName().equals(user.getName());
	}

	@Override
	public String toString() {
		return name.toUpperCase();
	}

}

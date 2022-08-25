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
@XmlType(propOrder = { "id", "name", "weeklyPlan" })
public class User {
	private int id;
	private String name;
	@XmlElementWrapper(name = "WeeklyPlans")
	@XmlElement(name = "WeekPlan")
	private List<WeekPlan> weeklyPlan = new ArrayList<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, List<WeekPlan> weeklyPlan) {
		super();
		this.id = id;
		this.name = name;
		this.weeklyPlan = weeklyPlan;
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
	 * @return the weeklyPlan
	 */
	public List<WeekPlan> getWeeklyPlan() {
		return weeklyPlan;
	}

	/**
	 * @param weeklyPlan the weeklyPlan to set
	 */
	public void addWeekPlan(WeekPlan weekPlan) {
		this.weeklyPlan.add(weekPlan);
	}

	public void removeWeekPlan(WeekPlan weekPlan) {
		this.weeklyPlan.remove(weekPlan);
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

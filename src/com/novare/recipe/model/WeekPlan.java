package com.novare.recipe.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "dietplan")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "weekName", "dailyPlan" })
public class WeekPlan {
	private String weekName;
	@XmlElementWrapper(name = "DailyPlans")
	@XmlElement(name = "DayPlan")
	private List<DayPlan> dailyPlan = new ArrayList<>();

	public WeekPlan() {
		// TODO Auto-generated constructor stub
	}

	public WeekPlan(String weekName, List<DayPlan> dailyPlan) {
		super();
		this.weekName = weekName;
		this.dailyPlan = dailyPlan;
	}

	/**
	 * @return the weekName
	 */
	public String getWeekName() {
		return weekName;
	}

	/**
	 * @param weekName the weekName to set
	 */
	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}

	/**
	 * @return the dayPlan
	 */
	public List<DayPlan> getDailyPlan() {
		return dailyPlan;
	}

	/**
	 * @param dayPlan the dayPlan to set
	 */
	public void addDailyPlan(DayPlan dayPlan) {
		this.dailyPlan.add(dayPlan);
	}

	@Override
	public String toString() {
		return weekName.toUpperCase();
	}

}

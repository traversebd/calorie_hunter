package com.spring.calorieApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String gender;
	private int weightInKg;
	private int heightInCm;
	private int age;
	private int activityLevelId;

	public Calorie() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getWeightInKg() {
		return weightInKg;
	}

	public void setWeightInKg(int weightInKg) {
		this.weightInKg = weightInKg;
	}

	public int getHeightInCm() {
		return heightInCm;
	}

	public void setHeightInCm(int heightInCm) {
		this.heightInCm = heightInCm;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getActivityLevelId() {
		return activityLevelId;
	}

	public void setActivityLevelId(int activityLevelId) {
		this.activityLevelId = activityLevelId;
	}

}

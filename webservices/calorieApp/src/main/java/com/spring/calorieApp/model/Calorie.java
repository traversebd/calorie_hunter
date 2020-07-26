package com.spring.calorieApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String Gender;
	private int WeightInKg;
	private int HeightInCm;
	private int Age;
	private int ActivityLevelId;

	public Calorie() {
		
	}

	public Calorie(int id, String gender, int weightInKg, int heightInCm, int age, int activityLevelId) {
		super();
		Id = id;
		Gender = gender;
		WeightInKg = weightInKg;
		HeightInCm = heightInCm;
		Age = age;
		ActivityLevelId = activityLevelId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getWeightInKg() {
		return WeightInKg;
	}

	public void setWeightInKg(int weightInKg) {
		WeightInKg = weightInKg;
	}

	public int getHeightInCm() {
		return HeightInCm;
	}

	public void setHeightInCm(int heightInCm) {
		HeightInCm = heightInCm;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getActivityLevelId() {
		return ActivityLevelId;
	}

	public void setActivityLevelId(int activityLevelId) {
		ActivityLevelId = activityLevelId;
	}

}

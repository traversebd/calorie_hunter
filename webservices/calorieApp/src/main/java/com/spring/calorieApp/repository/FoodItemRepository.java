package com.spring.calorieApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.calorieApp.model.FoodItem;
@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

}

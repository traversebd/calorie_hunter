package com.traversebd.calorie_hunter.db.mealplan;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;
import java.util.List;

@Dao
public interface MealPlanDao {
    @Insert
    void insert(MealPlan mealPlan);

    @Query("select * from MealPlan order by Id desc")
    LiveData<List<MealPlan>> getAllMalPlans();
}

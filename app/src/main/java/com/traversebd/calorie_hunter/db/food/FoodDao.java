package com.traversebd.calorie_hunter.db.food;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    void insert(FoodItem foodItem);

    @Update
    void update(FoodItem foodItem);

    @Insert
    void delete(FoodItem foodItem);

    @Query("select * from FoodItem order by Id desc")
    LiveData<List<FoodItem>> getAllFoodItems();

    @Query("select * from FoodItem where Id = :id limit 1")
    FoodItem getSingleItem(int id);
}

package com.traversebd.calorie_hunter.db.food;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import java.util.List;

public class FoodViewModel extends AndroidViewModel {
    private FoodRepository foodRepository;
    private LiveData<List<FoodItem>> allItems;

    //region constructor
    public FoodViewModel(@NonNull Application application) {
        super(application);
        foodRepository = new FoodRepository(application);
        allItems = foodRepository.getAllFoodItems();
    }
    //endregion
    
    //region all db operations
    public void insert(FoodItem foodItem){foodRepository.insert(foodItem);}
    public void update(FoodItem foodItem){foodRepository.update(foodItem);}
    public void delete(FoodItem foodItem){foodRepository.delete(foodItem);}
    public FoodItem getFoodItem(int id){return foodRepository.getSingleFoodItem(id);}
    public LiveData<List<FoodItem>> getAllFoodItems(){return allItems;}
    //endregion
}

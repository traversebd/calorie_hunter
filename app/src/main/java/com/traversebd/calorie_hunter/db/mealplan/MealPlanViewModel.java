package com.traversebd.calorie_hunter.db.mealplan;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;
import java.util.List;

public class MealPlanViewModel extends AndroidViewModel {
    private MealPlanRepository repository;
    private LiveData<List<MealPlan>> allMealPlans;

    public MealPlanViewModel(@NonNull Application application) {
        super(application);
        repository = new MealPlanRepository(application);
        allMealPlans = repository.getAllFoodItems();
    }

    //region all db operations
    public void insert(MealPlan mealPlan){repository.insert(mealPlan);}
    public LiveData<List<MealPlan>> getAllMealPlans(){return allMealPlans;}
    //endregion
}

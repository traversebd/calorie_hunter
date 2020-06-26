package com.traversebd.calorie_hunter.db.calculatecalorie;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.traversebd.calorie_hunter.models.calculatecalorie.Calorie;

public class CalorieViewModel extends AndroidViewModel {
    private CalorieRepository calorieRepository;

    //region constructor
    public CalorieViewModel(@NonNull Application application) {
        super(application);
        calorieRepository = new CalorieRepository(application);
    }
    //endregion

    //region all db operations
    public void insert(Calorie calorie){calorieRepository.insert(calorie);}
    //endregion
}

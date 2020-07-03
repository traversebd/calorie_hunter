package com.traversebd.calorie_hunter.db.healthtips;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;
import java.util.List;

public class HealthTipsViewModel extends AndroidViewModel {
    private HealthRepository healthRepository;
    private LiveData<List<HealthTips>> allItems;

    //region constructor
    public HealthTipsViewModel(@NonNull Application application) {
        super(application);
        healthRepository = new HealthRepository(application);
        allItems = healthRepository.getAllHealthItems();
    }
    //endregion

    //region all db operations
    public void insert(HealthTips healthTips){healthRepository.insert(healthTips);}
    public LiveData<List<HealthTips>> getAllHealthItems(){return allItems;}
    //endregion
}

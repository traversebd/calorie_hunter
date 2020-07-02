package com.traversebd.calorie_hunter.db.healthtips;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;

public class HealthTipsViewModel extends AndroidViewModel {
    private HealthRepository healthRepository;

    //region constructor
    public HealthTipsViewModel(@NonNull Application application) {
        super(application);
        healthRepository = new HealthRepository(application);
    }
    //endregion

    //region all db operations
    public void insert(HealthTips healthTips){healthRepository.insert(healthTips);}
    //endregion
}

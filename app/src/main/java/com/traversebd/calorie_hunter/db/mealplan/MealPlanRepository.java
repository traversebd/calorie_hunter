package com.traversebd.calorie_hunter.db.mealplan;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.traversebd.calorie_hunter.db.MasterDB;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;
import java.util.List;

public class MealPlanRepository {
    private MealPlanDao mealPlanDao;
    private LiveData<List<MealPlan>> allMealPlans;

    public MealPlanRepository(Application application) {
        MasterDB masterDB = MasterDB.getInstance(application);
        mealPlanDao = masterDB.mealPlanDao();
        allMealPlans = mealPlanDao.getAllMalPlans();
    }

    //region all operations
    public void insert(MealPlan mealPlan){ new InsertAsyncTask(mealPlanDao).execute(mealPlan); }
    public LiveData<List<MealPlan>> getAllFoodItems(){return allMealPlans; }
    //endregion

    //region insert food async task
    private static class InsertAsyncTask extends AsyncTask<MealPlan,Void,Void> {
        MealPlanDao mealPlanDao;

        public InsertAsyncTask(MealPlanDao mealPlanDao) {
            this.mealPlanDao = mealPlanDao;
        }

        @Override
        protected Void doInBackground(MealPlan... mealPlans) {
            mealPlanDao.insert(mealPlans[0]);
            return null;
        }
    }
    //endregion
}

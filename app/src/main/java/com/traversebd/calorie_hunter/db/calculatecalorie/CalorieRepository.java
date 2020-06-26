package com.traversebd.calorie_hunter.db.calculatecalorie;

import android.app.Application;
import android.os.AsyncTask;
import com.traversebd.calorie_hunter.db.MasterDB;
import com.traversebd.calorie_hunter.models.calculatecalorie.Calorie;

public class CalorieRepository {
    private CalorieDao calorieDao;

    public CalorieRepository(Application application) {
        MasterDB masterDB = MasterDB.getInstance(application);
        calorieDao = masterDB.calorieDao();
    }

    //region all operations
    public void insert(Calorie calorie){ new InsertAsyncTask(calorieDao).execute(calorie); };
    //endregion

    //region insert food async task
    private static class InsertAsyncTask extends AsyncTask<Calorie,Void,Void> {
        CalorieDao calorieDao;

        public InsertAsyncTask(CalorieDao calorieDao) {
            this.calorieDao = calorieDao;
        }

        @Override
        protected Void doInBackground(Calorie... calories) {
            calorieDao.insert(calories[0]);
            return null;
        }
    }
    //endregion
}

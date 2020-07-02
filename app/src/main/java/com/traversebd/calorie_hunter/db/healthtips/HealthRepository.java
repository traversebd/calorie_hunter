package com.traversebd.calorie_hunter.db.healthtips;

import android.app.Application;
import android.os.AsyncTask;
import com.traversebd.calorie_hunter.db.MasterDB;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;

public class HealthRepository {
    HealthTipsDao healthTipsDao;

    public HealthRepository(Application application) {
        MasterDB masterDB = MasterDB.getInstance(application);
        healthTipsDao = masterDB.healthTipsDao();
    }

    //region all operations
    public void insert(HealthTips healthTips){ new InsertAsyncTask(healthTipsDao).execute(healthTips); };
    //endregion

    //region insert health tips async task
    private static class InsertAsyncTask extends AsyncTask<HealthTips,Void,Void> {
        HealthTipsDao healthTipsDao;

        public InsertAsyncTask(HealthTipsDao healthTipsDao) {
            this.healthTipsDao = healthTipsDao;
        }

        @Override
        protected Void doInBackground(HealthTips... calories) {
            healthTipsDao.insert(calories[0]);
            return null;
        }
    }
    //endregion
}

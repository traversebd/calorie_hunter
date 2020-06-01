package com.traversebd.calorie_hunter.db.food;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.traversebd.calorie_hunter.db.MasterDB;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import java.util.List;

public class FoodRepository {
    private FoodDao foodDao;
    private LiveData<List<FoodItem>> allItems;

    public FoodRepository(Application application) {
        MasterDB masterDB = MasterDB.getInstance(application);
        foodDao = masterDB.foodDao();
        allItems = foodDao.getAllFoodItems();
    }

    //region all operations
    public void insert(FoodItem foodItem){ new InsertAsyncTask(foodDao).execute(foodItem); };
    public void update(FoodItem foodItem){ new UpdateAsyncTask(foodDao).execute(foodItem); };
    public void delete(FoodItem foodItem){ new DeleteAsyncTask(foodDao).execute(foodItem); };
    public LiveData<List<FoodItem>> getAllFoodItems(){return allItems;};
    //endregion

    //region insert food async task
    private static class InsertAsyncTask extends AsyncTask<FoodItem,Void,Void> {
        FoodDao foodDao;

        public InsertAsyncTask(FoodDao foodDao) {
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(FoodItem... foodItems) {
            foodDao.insert(foodItems[0]);
            return null;
        }
    }
    //endregion

    //region update food async task
    private static class UpdateAsyncTask extends AsyncTask<FoodItem,Void,Void>{
        FoodDao foodDao;

        public UpdateAsyncTask(FoodDao foodDao) {
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(FoodItem... foodItems) {
            foodDao.update(foodItems[0]);
            return null;
        }
    }
    //endregion

    //region delete food async task
    private static class DeleteAsyncTask extends AsyncTask<FoodItem,Void,Void>{
        FoodDao foodDao;

        public DeleteAsyncTask(FoodDao foodDao) {
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(FoodItem... foodItems) {
            foodDao.delete(foodItems[0]);
            return null;
        }
    }
    //endregion
}

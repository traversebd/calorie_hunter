package com.traversebd.calorie_hunter.db;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.traversebd.calorie_hunter.db.food.FoodDao;
import com.traversebd.calorie_hunter.models.food.FoodItem;

@Database(entities = {FoodItem.class},version = 1)
public abstract class MasterDB extends RoomDatabase {
    private static MasterDB masterDB;

    public abstract FoodDao foodDao();

    //region get singletone async task
    public static synchronized MasterDB getInstance(Context context){
        if (masterDB == null){
            masterDB = Room.databaseBuilder(context.getApplicationContext(),MasterDB.class,"calorie_hunter")
                    .fallbackToDestructiveMigration()
                    .addCallback(foodCallback)
                    .build();
        }
        return masterDB;
    }
    //endregion

    //region ad callback for populating items
    private static RoomDatabase.Callback foodCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateFoodAsyncTask(masterDB).execute();
        }
    };
    //endregion

    //region add some dummy food async task
    private static class PopulateFoodAsyncTask extends AsyncTask<Void,Void,Void> {
        FoodDao foodDao;
        public PopulateFoodAsyncTask(MasterDB masterDB) {
            foodDao = masterDB.foodDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            foodDao.insert(new FoodItem(1,"Breakfast","Egg Boiled",0,155,11,0,13,124,1.1,1.1));
            foodDao.insert(new FoodItem(1,"Breakfast","Coffee",0,0,0,0,0.1,2,0,0));
            foodDao.insert(new FoodItem(1,"Breakfast","Pan Cake",0,0,0,0,1.1,12,1,20));
            foodDao.insert(new FoodItem(2,"Lunch","Steak Chimichurri",0,860,58,7,42,2110,10,49));
            foodDao.insert(new FoodItem(2,"Lunch","Cowboy Caviar",0,25,0,1,1,115,0,6));
            foodDao.insert(new FoodItem(2,"Lunch","Biriani",0,125,1212,12,11,115,0,62));
            foodDao.insert(new FoodItem(3,"Snacks","Buttermilk Pancakes",0,1791,58,7,49,2237.2,74.1,267));
            foodDao.insert(new FoodItem(3,"Snacks","Coconut Rice Pudding",0,1298,50,9,19,34,28.8,196));
            foodDao.insert(new FoodItem(3,"Snacks","Singara",0,18,5,90,19,34,28.8,196));
            foodDao.insert(new FoodItem(4,"Dinner","Chickpea Soup",0,194.4,6.6,6.4,5.3,1031.1,6.1,29.9));
            foodDao.insert(new FoodItem(4,"Dinner","Spinach and Artichoke Pizza",0,275.9,8.4,5.7,13.3,1122.1,4.1,38.5));
            foodDao.insert(new FoodItem(4,"Dinner","Chicken BBQ Pizza",0,275.9,11.4,5.1,12.3,1122.1,4.1,28.5));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
    //endregion
}

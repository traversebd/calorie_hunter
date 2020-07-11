package com.traversebd.calorie_hunter.db;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.db.calculatecalorie.CalorieDao;
import com.traversebd.calorie_hunter.db.food.FoodDao;
import com.traversebd.calorie_hunter.db.healthtips.HealthTipsDao;
import com.traversebd.calorie_hunter.db.mealplan.MealPlanDao;
import com.traversebd.calorie_hunter.models.calculatecalorie.Calorie;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;

@Database(entities = {FoodItem.class, Calorie.class, HealthTips.class, MealPlan.class},version = 1)
public abstract class MasterDB extends RoomDatabase {
    private static MasterDB masterDB;

    public abstract FoodDao foodDao();
    public abstract CalorieDao calorieDao();
    public abstract HealthTipsDao healthTipsDao();
    public abstract MealPlanDao mealPlanDao();

    //region get single-tone async task
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
            new PopulateDataAsyncTask(masterDB).execute();
        }
    };
    //endregion

    //region add some dummy food async task
    private static class PopulateDataAsyncTask extends AsyncTask<Void,Void,Void> {
        FoodDao foodDao;
        HealthTipsDao healthTipsDao;
        MealPlanDao mealPlanDao;

        public PopulateDataAsyncTask(MasterDB masterDB) {
            foodDao = masterDB.foodDao();
            healthTipsDao = masterDB.healthTipsDao();
            mealPlanDao = masterDB.mealPlanDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //region add food item
            foodDao.insert(new FoodItem(1,"Breakfast","Egg Boiled","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_egg,155,11,0,13,124,1.1,112,1.1,12));
            foodDao.insert(new FoodItem(1,"Breakfast","Coffee","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_coffee,0,0,0,0.1,2,0,112,0,1));
            foodDao.insert(new FoodItem(1,"Breakfast","Pan Cake","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_cookie,0,0,0,1.1,12,1,112,20,11));
            foodDao.insert(new FoodItem(2,"Lunch","Steak Chimichurri","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_meat,860,58,7,42,2110,10,112,49,32));
            foodDao.insert(new FoodItem(2,"Lunch","Cowboy Caviar","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_caviar,25,0,1,1,115,0,112,6,0));
            foodDao.insert(new FoodItem(2,"Lunch","Biryani","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_biryani,125,1212,12,11,115,0,112,62,14));
            foodDao.insert(new FoodItem(3,"Snacks","Buttermilk Pancakes","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_cookie,1791,58,7,49,2237.2,74.1,112,267,0.1));
            foodDao.insert(new FoodItem(3,"Snacks","Coconut Rice Pudding","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_pudding,1298,50,9,19,34,28.8,112,196,0.23));
            foodDao.insert(new FoodItem(3,"Snacks","Samosa","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_samosa,18,5,90,19,34,28.8,112,196,0));
            foodDao.insert(new FoodItem(4,"Dinner","Chickpea Soup","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_soup,194.4,6.6,6.4,5.3,1031.1,6.1,112,29.9,0.2));
            foodDao.insert(new FoodItem(4,"Dinner","Spinach and Artichoke Pizza","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_chicken_pizza,275.9,8.4,5.7,13.3,1122.1,4.1,112,38.5,0.12));
            foodDao.insert(new FoodItem(4,"Dinner","Chicken BBQ Pizza","Food is any substance consumed to provide nutritional support for an organism.",
                    "This oily fish, known for its bright pink color, is rich not only in healthy protein but also in omega-3 fatty acids, which benefit both your heart and your brain.",
                    R.drawable.ic_bbq_pizza,275.9,11.4,5.1,12.3,1122.1,4.1,112,28.5,19));
            //endregion

            //region add health tips list
            healthTipsDao.insert(new HealthTips("Eat a variety of foods ","22-Jun-2020","For good health, we need more than 40 different nutrients, " +
                    "and no single food can supply them all.","For good health, we need more than 40 different nutrients, and no single food can supply them all. " +
                    "It is not about a single meal, it is about a balanced food choice over time that will make a difference!",
                    "A high-fat lunch could be followed by a low-fat dinner.;After a large meat portion at dinner, perhaps fish should be the next day’s choice?"));
            healthTipsDao.insert(new HealthTips("Reduce salt and sugar intake","20-Aug-2019","A high salt intake can result in high blood pressure, and " +
                    "increase the risk of cardiovascular disease.","A high salt intake can result in high blood pressure, and increase the risk of cardiovascular disease.;" +
                    "There are different ways to reduce salt in the diet.",
                    "When shopping, we could choose products with lower sodium content.;When cooking, salt can be substituted with spices, increasing the variety of flavours and tastes."));
            healthTipsDao.insert(new HealthTips("Eat regularly, control the portion size","10-Sep-2019","Eating a variety of foods, regularly, and in the right amounts" +
                    " is the best formula for a healthy diet.","Paying attention to portion size will help us not to consume too much calories, and will allow us to eat all the foods we enjoy, " +
                    "without having to eliminate any.","Cooking the right amount makes it easier to not overeat.;Some reasonable serving sizes are: 100 g of meat one medium piece of fruit " +
                    "half a cup of raw pasta."));
            healthTipsDao.insert(new HealthTips("Drink plenty of fluids","02-July-2020","Adults need to drink at least 1.5 litres of fluid a day!",
                    "Water is the best source, of course, and we can use tap or mineral water, sparkling or non-sparkling, plain or flavoured. Fruit juices, " +
                            "tea, soft drinks, milk and other drinks, can all be okay - from time to time.","It's important for your body to have plenty of fluids each day.;" +
                    "Water helps you digest your food, absorb nutrients from food, and then get rid of the unused waste."));
            healthTipsDao.insert(new HealthTips("Maintain a healthy body weight","08-May-2019","The right weight for each us depends on factors like our " +
                    "gender, height, age, and genes.","The right weight for each us depends on factors like our gender, height, age, and genes. Being affected by obesity and " +
                    "overweight increases the risks of a wide range of diseases, including diabetes, heart diseases, and cancer.",
                    "Excess body fat comes from eating more than we need.The extra calories can come from any caloric nutrient - " +
                            "protein, fat, carbohydrate, or alcohol.;Fat is the most concentrated source of energy."));
            //endregion

            //insert meal plan list items
            mealPlanDao.insert(new MealPlan("Saturday",0,"Breakfast","1,2"));
            mealPlanDao.insert(new MealPlan("Sunday",0,"Lunch","2,3"));
            mealPlanDao.insert(new MealPlan("Monday",0,"Dinner","3,4"));
            mealPlanDao.insert(new MealPlan("Tuesday",0,"Breakfast","4,3"));
            mealPlanDao.insert(new MealPlan("Wednesday",0,"Lunch","5,6"));
            mealPlanDao.insert(new MealPlan("Thursday",0,"Dinner","6,7"));
            mealPlanDao.insert(new MealPlan("Friday",0,"Breakfast","2,3,4"));
            //endregion
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
    //endregion
}

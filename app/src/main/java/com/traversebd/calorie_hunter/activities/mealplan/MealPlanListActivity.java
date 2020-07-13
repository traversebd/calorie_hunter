package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.adapters.MealPlanListAdapter;
import com.traversebd.calorie_hunter.db.food.FoodViewModel;
import com.traversebd.calorie_hunter.db.mealplan.MealPlanViewModel;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.traversebd.calorie_hunter.models.mealplan.CustomMealPlanList;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;
import com.traversebd.calorie_hunter.utils.UX;
import com.traversebd.calorie_hunter.utils.layoutmanager.VegaLayoutManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MealPlanListActivity extends AppCompatActivity {
    private ArrayList<MealPlan> allMealPlans;
    private ArrayList<CustomMealPlanList> customMealPlanLists;
    private UX ux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_list);

        //region init and bind all UI operations
        initUI();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void initUI() {
        allMealPlans = new ArrayList<>();
        customMealPlanLists = new ArrayList<>();
        ux = new UX(this);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MealPlanListActivity.this,HomeActivity.class));
            }
        });
        //endregion

        //region get data
        MealPlanViewModel viewModel = ViewModelProviders.of(this).get(MealPlanViewModel.class);
        viewModel.getAllMealPlans().observe(this, new Observer<List<MealPlan>>() {
            @Override
            public void onChanged(List<MealPlan> mealPlans) {
                allMealPlans = new ArrayList<>(mealPlans);
                prepareDataList();
                //region set recycler adapter
                setFoodRecycler();
                //endregion
            }
        });
        //endregion
    }
    //endregion

    //region set all meal plan list recycler
    private void setFoodRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.allFoodRecycler);
        recyclerView.setLayoutManager(new VegaLayoutManager());
        MealPlanListAdapter adapter = new MealPlanListAdapter(customMealPlanLists);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    //endregion

    //region get data list
    private void prepareDataList() {
        for (int start = 0; start < allMealPlans.size(); start++) {
            CustomMealPlanList customMealPlanList = new CustomMealPlanList();
            customMealPlanList.setId(allMealPlans.get(start).getId());
            customMealPlanList.setDayOfWeek(allMealPlans.get(start).getDayOfWeek());
            customMealPlanList.setFoodType(allMealPlans.get(start).getFoodType());
            customMealPlanList.setIconRes(allMealPlans.get(start).getIconRes());
            customMealPlanLists.add(start,customMealPlanList);
        }
        new GetSingleFoodItem(this).execute();
    }
    //end region

    //region will fetch single food item by id
    private static class GetSingleFoodItem extends AsyncTask<Void, Void, String> {
        WeakReference<MealPlanListActivity> referenceActivity;
        FoodViewModel foodViewModel;

        public GetSingleFoodItem(MealPlanListActivity referenceActivity) {
            this.referenceActivity = new WeakReference<>(referenceActivity);
            foodViewModel = ViewModelProviders.of(referenceActivity).get(FoodViewModel.class);
        }

        @Override
        protected void onPreExecute() {
            referenceActivity.get().ux.getLoadingView();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int start = 0; start < referenceActivity.get().allMealPlans.size(); start++) {
                if (referenceActivity.get().allMealPlans.get(start).getFoodItems() != null){
                    //region get food items by id
                    String[] foodItemId = referenceActivity.get().allMealPlans.get(start).getFoodItems().split(";");
                    if (foodItemId != null){
                        ArrayList<FoodItem> foodItemList = new ArrayList<>();
                        for (int innerIndex = 0; innerIndex < foodItemId.length; innerIndex++) {
                            FoodItem foodItem = foodViewModel.getFoodItem(Integer.valueOf(foodItemId[innerIndex]));
                            foodItemList.add(foodItem);
                        }
                        referenceActivity.get().customMealPlanLists.get(start).setAllFoodItems(foodItemList);
                    }
                    //endregion
                }
            }
            return "ok";
        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equals("ok")){
                if (referenceActivity.get().ux.loadingDialog.isShowing()){
                    referenceActivity.get().ux.removeLoadingView();
                }
            }
        }
    }
    //chart building done

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MealPlanListActivity.this, HomeActivity.class));
    }
    //endregion
}

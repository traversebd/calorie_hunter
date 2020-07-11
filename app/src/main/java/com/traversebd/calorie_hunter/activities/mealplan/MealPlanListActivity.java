package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.adapters.MealPlanListAdapter;
import com.traversebd.calorie_hunter.db.food.FoodViewModel;
import com.traversebd.calorie_hunter.db.mealplan.MealPlanViewModel;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;
import com.traversebd.calorie_hunter.utils.layoutmanager.VegaLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class MealPlanListActivity extends AppCompatActivity {
    private MealPlanViewModel viewModel;
    private ArrayList<MealPlan> allMealPlans;

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
        viewModel = ViewModelProviders.of(this).get(MealPlanViewModel.class);
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
        viewModel.getAllFoodItems().observe(this, new Observer<List<MealPlan>>() {
            @Override
            public void onChanged(List<MealPlan> mealPlans) {
                allMealPlans = new ArrayList<>(mealPlans);
            }
        });
        //endregion

        //region set recycler adapter
        setFoodRecycler();
        //endregion
    }
    //endregion

    //region set all meal plan list recycler
    private void setFoodRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.allFoodRecycler);
        recyclerView.setLayoutManager(new VegaLayoutManager());
        MealPlanListAdapter adapter = new MealPlanListAdapter(prepareDataList());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    //endregion

    //region get data list
    private ArrayList<MealPlan> prepareDataList() {
        FoodViewModel foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        for (int start = 0; start < allMealPlans.size(); start++) {
            if (allMealPlans.get(start).getFoodItems() != null){
                String[] foodItemId = allMealPlans.get(start).getFoodItems().split(".");
                if (foodItemId != null){
                    ArrayList<FoodItem> foodItemList = new ArrayList<>();
                    for (int innerIndex = 0; innerIndex < foodItemId.length; innerIndex++) {
                        FoodItem foodItem = foodViewModel.getFoodItem(Integer.valueOf(foodItemId[innerIndex]));
                        foodItemList.add(foodItem);
                    }
                    allMealPlans.get(start).setFoodItemList(foodItemList);
                }
            }
        }
        return allMealPlans;
    }
    //end region

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MealPlanListActivity.this, HomeActivity.class));
    }
    //endregion
}

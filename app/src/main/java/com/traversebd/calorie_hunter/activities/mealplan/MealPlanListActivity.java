package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.adapters.MealPlanListAdapter;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;
import com.traversebd.calorie_hunter.utils.layoutmanager.VegaLayoutManager;

import java.util.ArrayList;

public class MealPlanListActivity extends AppCompatActivity {

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
    }
    //endregion

    //region set all meal plan list recycler
    private void setFoodRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.allFoodRecycler);
        recyclerView.setLayoutManager(new VegaLayoutManager());
        MealPlanListAdapter adapter = new MealPlanListAdapter(prepareDataList(),this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    //endregion

    //region get data list
    private ArrayList<MealPlan> prepareDataList() {
        ArrayList<MealPlan> categorizedFoodList =new ArrayList<>();
        return categorizedFoodList;
    }
    //end region

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MealPlanListActivity.this, HomeActivity.class));
    }
    //endregion
}

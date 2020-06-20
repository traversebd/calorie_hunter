package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;

public class NewMealPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal_plan);

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

    }
    //endregion

    //region activity components

    @Override
    public void onBackPressed() {
        startActivity(new Intent(NewMealPlanActivity.this, MealPlanListActivity.class));
    }
    //endregion
}

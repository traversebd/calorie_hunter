package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.mealplan.CustomMealPlanList;

public class MealPlanDetailsActivity extends AppCompatActivity {
    private CustomMealPlanList mealPlan;
    private LinearLayout foodTitleContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_details);

        //region get intent data
        if (getIntent().getSerializableExtra("mealPlan") != null){
            loadExtraData();
        }

        //region init and bind all UI operations
        initUI();
        bindUiWithComponents();
        //endregion
    }

    //region get intent data
    private void loadExtraData(){
        mealPlan = (CustomMealPlanList) getIntent().getSerializableExtra("mealPlan");
    }
    //endregion

    //region all init operation
    private void initUI() {
        foodTitleContainer= findViewById(R.id.foodsTitleContainer);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region set food item title list
        setFoodsTitle();
        //endregion
    }
    //endregion

    //region set food item title list
    private void setFoodsTitle() {
        for (int start = 0; start < mealPlan.getAllFoodItems().size(); start++) {
            LinearLayout child = new LinearLayout(this);
            child.setOrientation(LinearLayout.HORIZONTAL);

            //get instance of textViews
            TextView serialTXT = new TextView(this);
            TextView separatorTXT = new TextView(this);
            TextView titleTXT = new TextView(this);
            //endregion

            //region set text size
            serialTXT.setTextSize(16);
            separatorTXT.setTextSize(16);
            titleTXT.setTextSize(16);
            //endregion

            //region set text color
            serialTXT.setTextColor(ContextCompat.getColor(this, R.color.md_green_900));
            separatorTXT.setTextColor(ContextCompat.getColor(this, R.color.md_green_900));
            titleTXT.setTextColor(ContextCompat.getColor(this, R.color.md_green_900));

            //region set text
            serialTXT.setText(""+(start+1));
            separatorTXT.setText(".");
            titleTXT.setText(mealPlan.getAllFoodItems().get(start).getTitle());
            //endregion

            //region set title text layout params and margin
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4,0,0,0);
            titleTXT.setLayoutParams(layoutParams);
            //endregion

            //region add all child to their main view
            child.addView(serialTXT);
            child.addView(separatorTXT);
            child.addView(titleTXT);
            foodTitleContainer.addView(child);
            //endregion
        }
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MealPlanDetailsActivity.this, MealPlanListActivity.class));
    }
    //endregion
}

package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
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
            //region main card and its support layout
            CardView cardView = new CardView(this);
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(192,128);
            cardView.setCardElevation(8);
            cardView.setTranslationZ(4);
            cardView.setLayoutParams(cardParams);
            cardView.setUseCompatPadding(true);
            cardView.setRadius(12);
            LinearLayout child = new LinearLayout(this);
            child.setOrientation(LinearLayout.VERTICAL);
            //endregion

            //region get instance of textViews
            TextView titleTXT = new TextView(this);
            TextView calorieTXT = new TextView(this);
            //endregion

            //region set layout params
            LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            titleParams.gravity = Gravity.CENTER_HORIZONTAL;
            titleTXT.setLayoutParams(titleParams);
            LinearLayout.LayoutParams calorieParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            calorieParams.gravity = Gravity.CENTER_VERTICAL;
            calorieTXT.setLayoutParams(calorieParams);
            //endregion

            //region set text size
            titleTXT.setTextSize(14);
            calorieTXT.setTextSize(14);
            //endregion

            //region set text color and padding
            titleTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.md_green_400));
            titleTXT.setTextColor(ContextCompat.getColor(this, R.color.md_white_1000));
            calorieTXT.setTextColor(ContextCompat.getColor(this, R.color.md_green_900));
            titleTXT.setPadding(8,8,8,8);
            calorieTXT.setPadding(8,8,8,8);
            //endregion

            //region set ellipsize and max lines
            titleTXT.setMaxLines(1);
            titleTXT.setEllipsize(TextUtils.TruncateAt.END);
            calorieTXT.setMaxLines(1);
            calorieTXT.setEllipsize(TextUtils.TruncateAt.END);
            //endregion

            //region set text
            titleTXT.setText(mealPlan.getAllFoodItems().get(start).getTitle());
            calorieTXT.setText(""+mealPlan.getAllFoodItems().get(start).getAmountOfCalorie());
            //endregion

            //region set gravity
            titleTXT.setGravity(Gravity.CENTER);
            calorieTXT.setGravity(Gravity.CENTER);
            //endregion

            //region add all child to their main view
            child.addView(titleTXT);
            child.addView(calorieTXT);
            cardView.addView(child);
            foodTitleContainer.addView(cardView);
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

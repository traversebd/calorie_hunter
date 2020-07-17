package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.mealplan.CustomMealPlanList;
import com.traversebd.calorie_hunter.utils.UX;

public class MealPlanDetailsActivity extends AppCompatActivity {
    private CustomMealPlanList mealPlan;
    private LinearLayout foodTitleContainer;
    private UX ux;

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
        ux = new UX(this);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {

        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MealPlanDetailsActivity.this, MealPlanListActivity.class));
            }
        });
        //endregion

        //region set food item title list
        setFoodsTitle();
        //endregion
    }
    //endregion

    //region set food item title list
    private void setFoodsTitle() {
        for (int start = 0; start < mealPlan.getAllFoodItems().size(); start++) {
            //region main card and its support layout
            CardView cardView = ux.getCardView(192,392,8,4,true,16);
            LinearLayout child = new LinearLayout(this);
            child.setOrientation(LinearLayout.VERTICAL);
            //endregion

            //region get instance of textViews
            TextView titleTXT = new TextView(this);
            TextView calorieTXT = new TextView(this);
            //endregion

            //region set layout params
            titleTXT.setLayoutParams(ux.getLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 86, Gravity.CENTER));
            calorieTXT.setLayoutParams(ux.getLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER));
            //endregion

            //region set text size
            ux.setTextSize(new TextView[]{titleTXT,calorieTXT},14);
            //endregion

            //region set text color and padding
            ux.setBackgroundColor(new TextView[]{titleTXT}, ContextCompat.getColor(this, R.color.md_green_400));
            ux.setTextColor(new TextView[]{titleTXT}, ContextCompat.getColor(this, R.color.md_white_1000));
            ux.setTextColor(new TextView[]{calorieTXT}, ContextCompat.getColor(this, R.color.md_green_900));
            ux.setTextPadding(new TextView[]{titleTXT, calorieTXT},8,8,8,8);
            //endregion

            //region set ellipsize and max lines
            ux.setEllipsizeWithMaxLines(new TextView[]{titleTXT,calorieTXT},1);
            //endregion

            //region set text
            titleTXT.setText(mealPlan.getAllFoodItems().get(start).getTitle());
            calorieTXT.setText(""+mealPlan.getAllFoodItems().get(start).getAmountOfCalorie()+" KCal");
            //endregion

            //region set gravity
            ux.setTextGravity(new TextView[]{titleTXT, calorieTXT}, Gravity.CENTER);
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

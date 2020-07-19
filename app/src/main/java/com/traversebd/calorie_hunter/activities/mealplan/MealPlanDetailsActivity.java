package com.traversebd.calorie_hunter.activities.mealplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.traversebd.calorie_hunter.models.mealplan.CustomMealPlanList;
import com.traversebd.calorie_hunter.utils.UX;

public class MealPlanDetailsActivity extends AppCompatActivity {
    private CustomMealPlanList mealPlan;
    private LinearLayout foodTitleContainer;
    private UX ux;
    private ImageView iconBreakfast, iconLunch, iconDinner;
    private TextView titleBreakfast, titleLunch, titleDinner, descriptionBreakfast, descriptionLunch, descriptionDinner, amountOfCalorieBreakfast, amountOfCalorieLunch, amountOfCalorieDinner
            , amountOfProteinBreakfast, amountOfProteinLunch, amountOfProteinDinner, amountOfCarbsBreakfast, amountOfCarbsLunch, amountOfCarbsDinner;

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
        iconBreakfast = findViewById(R.id.IconBreakfast);
        iconLunch = findViewById(R.id.IconLunch);
        iconDinner = findViewById(R.id.IconDinner);
        titleBreakfast = findViewById(R.id.TitleBreakfast);
        titleLunch = findViewById(R.id.TitleLunch);
        titleDinner = findViewById(R.id.TitleDinner);
        descriptionBreakfast = findViewById(R.id.FoodShortDescriptionBreakfast);
        descriptionLunch = findViewById(R.id.FoodDescriptionLunch);
        descriptionDinner = findViewById(R.id.FoodDescriptionDinner);
        amountOfCalorieBreakfast = findViewById(R.id.AmountOfCalorieBreakfast);
        amountOfCalorieLunch = findViewById(R.id.AmountOfCalorieLunch);
        amountOfCalorieDinner = findViewById(R.id.AmountOfCalorieDinner);
        amountOfProteinBreakfast = findViewById(R.id.AmountOfProteinBreakfast);
        amountOfProteinLunch = findViewById(R.id.AmountOfProteinLunch);
        amountOfProteinDinner = findViewById(R.id.AmountOfProteinDinner);
        amountOfCarbsBreakfast = findViewById(R.id.AmountOfCarbohydratesBreakfast);
        amountOfCarbsLunch = findViewById(R.id.AmountOfCarbohydratesLunch);
        amountOfCarbsDinner = findViewById(R.id.AmountOfCarbohydratesDinner);
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

        //region set breakfast food details
        setBreakfastFoodDetails();
        //endregion

        //region set lunch food details
        setLunchFoodDetails();
        //endregion

        //region set dinner food details
        setDinnerFoodDetails();
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

    //region set all food details
    private void setBreakfastFoodDetails() {
        if (getBreakfastItem() != null){
            FoodItem foodItem = getBreakfastItem();
            iconBreakfast.setImageResource(foodItem.getIcon());
            titleBreakfast.setText(foodItem.getTitle());
            descriptionBreakfast.setText(foodItem.getFoodShortDescription());
            amountOfCalorieBreakfast.setText(""+foodItem.getAmountOfCalorie());
            amountOfProteinBreakfast.setText(""+foodItem.getAmountOfProtein());
            amountOfCarbsBreakfast.setText(""+foodItem.getAmountOfCarbohydrates());
        }
    }

    private void setLunchFoodDetails() {
        if (getLunchItem() != null){
            FoodItem foodItem = getLunchItem();
            iconLunch.setImageResource(foodItem.getIcon());
            titleLunch.setText(foodItem.getTitle());
            descriptionLunch.setText(foodItem.getFoodShortDescription());
            amountOfCalorieLunch.setText(""+foodItem.getAmountOfCalorie());
            amountOfProteinLunch.setText(""+foodItem.getAmountOfProtein());
            amountOfCarbsLunch.setText(""+foodItem.getAmountOfCarbohydrates());
        }
    }

    private void setDinnerFoodDetails() {
        if (getDinnerItem() != null){
            FoodItem foodItem = getDinnerItem();
            iconDinner.setImageResource(foodItem.getIcon());
            titleDinner.setText(foodItem.getTitle());
            descriptionDinner.setText(foodItem.getFoodShortDescription());
            amountOfCalorieDinner.setText(""+foodItem.getAmountOfCalorie());
            amountOfProteinDinner.setText(""+foodItem.getAmountOfProtein());
            amountOfCarbsDinner.setText(""+foodItem.getAmountOfCarbohydrates());
        }
    }
    //endregion

    //region get breakfast food item
    private FoodItem getBreakfastItem(){
        FoodItem breakfastItem = null;
        for (FoodItem foodItem: mealPlan.getAllFoodItems()) {
            if (foodItem.getFoodTypeId() == 1){
                breakfastItem = foodItem;
                return breakfastItem;
            }
        }
        return breakfastItem;
    }
    //endregion

    //region get lunch food item
    private FoodItem getLunchItem(){
        FoodItem lunchItem = null;
        for (FoodItem foodItem: mealPlan.getAllFoodItems()) {
            if (foodItem.getFoodTypeId() == 2){
                lunchItem = foodItem;
                return lunchItem;
            }
        }
        return lunchItem;
    }
    //endregion

    //region get dinner food item
    private FoodItem getDinnerItem(){
        FoodItem dinnerItem = null;
        for (FoodItem foodItem: mealPlan.getAllFoodItems()) {
            if (foodItem.getFoodTypeId() == 3){
                dinnerItem = foodItem;
                return dinnerItem;
            }
        }
        return dinnerItem;
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MealPlanDetailsActivity.this, MealPlanListActivity.class));
    }
    //endregion
}

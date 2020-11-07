package com.traversebd.calorie_hunter.activities.fooditems;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.traversebd.calorie_hunter.utils.Tools;

public class FoodDetailsActivity extends AppCompatActivity {
    private TextView toolbarTitle, foodShortDescription, foodDescription;
    private ImageView foodIcon;
    private FoodItem foodItem;
    private ArcProgress amountOfCalorieProgress, amountOfFatProgress, amountOfFiberProgress, amountOfProteinProgress, amountOfSodiumProgress, amountOfSugarProgress
            ,amountOfCholesterolProgress, amountOfCarbsProgress, amountOfMagnesiumProgress;
    private Tools tools;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        //region perform all kinds of operations
        init();
        bindUiWithComponents();
        //endregion
    }

    //region init UI components with backend
    private void init(){
        toolbarTitle = findViewById(R.id.toolbarTitle);
        foodIcon = findViewById(R.id.Icon);
        foodShortDescription = findViewById(R.id.FoodShortDescription);
        foodDescription = findViewById(R.id.FoodDescription);
        tools = new Tools(this);
        amountOfCalorieProgress = findViewById(R.id.amountOfCalorieProgress);
        amountOfFatProgress = findViewById(R.id.amountOfFatProgress);
        amountOfFiberProgress = findViewById(R.id.amountOfFiberProgress);
        amountOfProteinProgress = findViewById(R.id.amountOfProteinProgress);
        amountOfSodiumProgress = findViewById(R.id.amountOfSodiumProgress);
        amountOfSugarProgress = findViewById(R.id.amountOfSugarProgress);
        amountOfCholesterolProgress = findViewById(R.id.amountOfCholesterolProgress);
        amountOfCarbsProgress = findViewById(R.id.amountOfCarbsProgress);
        amountOfMagnesiumProgress = findViewById(R.id.amountOfMagnesiumProgress);
    }
    //endregion

    //region perform all the UI interactions
    private void bindUiWithComponents(){
        //region back button action
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //endregion

        //region load intent data
        loadIntentData();
        //endregion

        //region set toolbar title
        if (foodItem != null) {
            toolbarTitle.setText(foodItem.getTitle());
        } else {
            toolbarTitle.setText("No Data Found");
        }
        //endregion

        //region set all details
        if (foodItem!= null) {
            setData();
        }
        //endregion
    }
    //endregion

    //region load data
    private void loadIntentData() {
        foodItem = (FoodItem) getIntent().getSerializableExtra("foodItem");
    }
    //endregion

    //region set all th details
    private void setData(){
        foodIcon.setImageResource(foodItem.getIcon());
        foodShortDescription.setText(foodItem.getFoodShortDescription());
        foodDescription.setText(foodItem.getFoodDescription());

        tools.setArcMaxProgress(new ArcProgress[]{amountOfCalorieProgress, amountOfFatProgress,amountOfFiberProgress,amountOfProteinProgress,amountOfSodiumProgress,
                amountOfSugarProgress, amountOfCholesterolProgress, amountOfCarbsProgress, amountOfMagnesiumProgress},100);

        amountOfCalorieProgress.setProgress((int) foodItem.getAmountOfCalorie());
        amountOfFatProgress.setProgress((int) foodItem.getAmountOfFat());
        amountOfFiberProgress.setProgress((int) foodItem.getAmountOfFiber());
        amountOfProteinProgress.setProgress((int) foodItem.getAmountOfProtein());
        amountOfSodiumProgress.setProgress((int) foodItem.getAmountOfSodium());
        amountOfSugarProgress.setProgress((int) foodItem.getAmountOfSugar());
        amountOfCholesterolProgress.setProgress((int) foodItem.getAmountOfCholesterol());
        amountOfCarbsProgress.setProgress((int) foodItem.getAmountOfCarbohydrates());
        amountOfMagnesiumProgress.setProgress((int) foodItem.getAmountOfMagnesium());
    }
    //endregion

    //region activity own method and their operations
    @Override
    public void onBackPressed() {
        if (getIntent().getStringExtra("from").equals("home")) {
            startActivity(new Intent(FoodDetailsActivity.this, HomeActivity.class));
        }
        else if (getIntent().getStringExtra("from").equals("foodList")) {
            int foodType = getIntent().getIntExtra("foodType",0);
            startActivity(new Intent(FoodDetailsActivity.this, FoodListActivity.class).putExtra("foodType",foodType));
        }
    }
    //endregion
}

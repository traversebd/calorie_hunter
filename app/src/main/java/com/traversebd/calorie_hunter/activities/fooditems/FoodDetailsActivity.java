package com.traversebd.calorie_hunter.activities.fooditems;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.models.food.FoodItem;

public class FoodDetailsActivity extends AppCompatActivity {
    private TextView toolbarTitle, foodShortDescription, foodDescription, amountOfCalorie, amountOfFat, amountOfFiber, amountOfProtein, amountOfSodium,
            amountOfSugar,amountOfCholesterol, amountOfCarbs, amountOfMagnesium;
    private ImageView foodIcon;
    private FoodItem foodItem;
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
        amountOfCalorie = findViewById(R.id.AmountOfCalorie);
        amountOfFat = findViewById(R.id.AmountOfFat);
        amountOfFiber = findViewById(R.id.AmountOfFiber);
        amountOfProtein = findViewById(R.id.AmountOfProtein);
        amountOfSodium = findViewById(R.id.AmountOfSodium);
        amountOfSugar = findViewById(R.id.AmountOfSugar);
        amountOfCholesterol = findViewById(R.id.AmountOfCholesterol);
        amountOfCarbs = findViewById(R.id.AmountOfCarbohydrates);
        amountOfMagnesium = findViewById(R.id.AmountOfMagnesium);
    }
    //endregion

    //region perform all the UI interactions
    private void bindUiWithComponents(){
        //region back button action
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodDetailsActivity.this,HomeActivity.class));
            }
        });
        //endregion

        //region load intent data
        loadIntentData();
        //endregion

        //region set toolbar title
        toolbarTitle.setText(foodItem.getTitle());
        //endregion

        //region set all details
        setData();
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
        amountOfCalorie.setText(""+foodItem.getAmountOfCalorie());
        amountOfFat.setText(""+foodItem.getAmountOfFat());
        amountOfFiber.setText(""+foodItem.getAmountOfFiber());
        amountOfProtein.setText(""+foodItem.getAmountOfProtein());
        amountOfSodium.setText(""+foodItem.getAmountOfSodium());
        amountOfSugar.setText(""+foodItem.getAmountOfSugar());
        amountOfCholesterol.setText(""+foodItem.getAmountOfCholesterol());
        amountOfCarbs.setText(""+foodItem.getAmountOfCarbohydrates());
        amountOfMagnesium.setText(""+foodItem.getAmountOfMagnesium());
    }
    //endregion

    //region activity own method and their operations
    @Override
    public void onBackPressed() {
        startActivity(new Intent(FoodDetailsActivity.this, HomeActivity.class));
    }
    //endregion
}

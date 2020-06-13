package com.traversebd.calorie_hunter.activities.fooditems;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.models.food.FoodItem;

public class FoodDetailsActivity extends AppCompatActivity {
    private TextView toolbarTitle;
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
    }
    //endregion

    //region load data
    private void loadIntentData() {
        foodItem = (FoodItem) getIntent().getSerializableExtra("foodItem");
    }
    //endregion

    //region activity own method and their operations
    @Override
    public void onBackPressed() {
        startActivity(new Intent(FoodDetailsActivity.this, HomeActivity.class));
    }
    //endregion
}

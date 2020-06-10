package com.traversebd.calorie_hunter.activities.fooditems;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;

public class FoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //region all works related to this activity
        init();
        bindUiWithComponents();
        //endregion
    }

    //region init all UI with backend
    private void init(){

    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents(){
        //region load intent data
        loadExtra();
        //endregion

        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodListActivity.this,HomeActivity.class));
            }
        });
        //endregion
    }
    //endregion

    //region load intent data
    private void loadExtra(){
        int foodType = 0;
        if (getIntent().getIntExtra("foodType",0) != 0){
            foodType = getIntent().getIntExtra("foodType",0);
        }
    }
    //endregion

    //region all system callbacks and methods
    @Override
    public void onBackPressed() {
        startActivity(new Intent(FoodListActivity.this, HomeActivity.class));
    }
    //endregion
}

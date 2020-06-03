package com.traversebd.calorie_hunter.activities.fooditems;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
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
    }
    //endregion

    //region load intent data
    private void loadExtra(){
        if (getIntent().getIntExtra("foodType",0) != 0){
            int foodType = getIntent().getIntExtra("foodType",0);
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

package com.traversebd.calorie_hunter.activities.fooditems;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;

public class FoodDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        //region perform all kinds of operations
        init();
        bindUiWithComponents();
        //endregion
    }

    //region init ui components with backend
    private void init(){

    }
    //endregion

    //region perform all the UI interactions
    private void bindUiWithComponents(){

    }
    //endregion

    //region activity own method and their operations
    @Override
    public void onBackPressed() {
        startActivity(new Intent(FoodDetailsActivity.this, HomeActivity.class));
    }
    //endregion
}

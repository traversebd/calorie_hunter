package com.traversebd.calorie_hunter.activities.calculatecalorie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;

public class CalculateCalorieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_calorie);

        //region init and bind all UI operations
        initUI();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void initUI() {

    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalculateCalorieActivity.this,CalculateCalorieListActivity.class));
            }
        });
        //endregion
    }
    //endregion
}

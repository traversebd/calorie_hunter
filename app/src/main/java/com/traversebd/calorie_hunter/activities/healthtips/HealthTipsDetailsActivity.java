package com.traversebd.calorie_hunter.activities.healthtips;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.traversebd.calorie_hunter.R;

public class HealthTipsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haelth_tips_details);

        //region init and bind all UI operations
        init();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void init() {
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
    }
    //endregion


    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(HealthTipsDetailsActivity.this, HealthTipsListActivity.class));
    }
    //endregion
}

package com.traversebd.calorie_hunter.activities.healthtips;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.adapters.HealthTipsSliderAdapter;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;

public class HealthTipsListActivity extends AppCompatActivity {
    private DiscreteScrollView healthTpsSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips_list);

        //region init and bind all UI operations
        init();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void init() {
        healthTpsSlider = findViewById(R.id.healthTipsSlider);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthTipsListActivity.this,HomeActivity.class));
            }
        });
        //endregion
    }
    //endregion

    //region set health tips slider type list
    private void setWalletAdapter(ArrayList<HealthTips> healthTips) {
        HealthTipsSliderAdapter sliderAdapter = new HealthTipsSliderAdapter(healthTips, this);
        healthTpsSlider.setAdapter(sliderAdapter);
        sliderAdapter.onItemClickListener(new HealthTipsSliderAdapter.onItemClick() {
            @Override
            public void itemClick(HealthTips healthTips) {
            }
        });
        healthTpsSlider.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());
        healthTpsSlider.setSlideOnFling(false);
        healthTpsSlider.scrollToPosition(0);
        healthTpsSlider.setOverScrollEnabled(false);
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(HealthTipsListActivity.this, HomeActivity.class));
    }
    //endregion
}

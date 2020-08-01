package com.traversebd.calorie_hunter.activities.nutritiontips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;

public class NutritionTipsListActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView bodyPortionLayout, listenToYourBodyLayout, moreFiberLayout, generalNutritionTipsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_tips_list);

        //region init and bind all UI operations
        initUI();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void initUI() {
        bodyPortionLayout = findViewById(R.id.bodyPortionLayout);
        listenToYourBodyLayout = findViewById(R.id.listenToYourBodyLayout);
        moreFiberLayout = findViewById(R.id.moreFiberLayout);
        generalNutritionTipsLayout = findViewById(R.id.generalNutritionTipsLayout);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NutritionTipsListActivity.this,HomeActivity.class));
            }
        });
        //endregion

        //region card item click listeners
        bodyPortionLayout.setOnClickListener(this);
        listenToYourBodyLayout.setOnClickListener(this);
        moreFiberLayout.setOnClickListener(this);
        generalNutritionTipsLayout.setOnClickListener(this);
        //endregion
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(NutritionTipsListActivity.this, HomeActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bodyPortionLayout:
                startActivity(new Intent(NutritionTipsListActivity.this, NutritionTipsDetailsActivity.class).putExtra("typeId",1));
                break;
            case R.id.listenToYourBodyLayout:
                startActivity(new Intent(NutritionTipsListActivity.this, NutritionTipsDetailsActivity.class).putExtra("typeId",2));
                break;
            case R.id.moreFiberLayout:
                startActivity(new Intent(NutritionTipsListActivity.this, NutritionTipsDetailsActivity.class).putExtra("typeId",3));
                break;
            case R.id.generalNutritionTipsLayout:
                startActivity(new Intent(NutritionTipsListActivity.this, NutritionTipsDetailsActivity.class).putExtra("typeId",4));
                break;
        }
    }
    //endregion
}

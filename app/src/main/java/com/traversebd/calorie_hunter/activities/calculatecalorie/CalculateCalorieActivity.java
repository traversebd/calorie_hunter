package com.traversebd.calorie_hunter.activities.calculatecalorie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.db.calculatecalorie.CalorieViewModel;

public class CalculateCalorieActivity extends AppCompatActivity {
    private RelativeLayout maleLayout, femaleLayout;
    private TextView male,female;
    private ImageView maleIcon, femaleIcon;
    private Button calculateButton;
    private CalorieViewModel calorieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_calorie);

        //region get viewModel
        calorieViewModel = ViewModelProviders.of(this).get(CalorieViewModel.class);
        //endregion

        //region init and bind all UI operations
        initUI();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void initUI() {
        maleLayout = findViewById(R.id.maleLayout);
        femaleLayout = findViewById(R.id.femaleLayout);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
        maleIcon = findViewById(R.id.MaleIcon);
        femaleIcon = findViewById(R.id.FemaleIcon);
        calculateButton = findViewById(R.id.calculateButton);
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

        //region gender click
        maleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeGender(getString(R.string.male));
            }
        });
        femaleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeGender(getString(R.string.female));
            }
        });
        //endregion

        //region calculate button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //endregion
    }
    //endregion

    //region change gender UI
    private void changeGender(String gender){
        if (gender.equals(getString(R.string.male))) {
            maleLayout.setBackground(ContextCompat.getDrawable(this,R.drawable.rectangle_background_filled_gender));
            male.setBackgroundResource(0);
            male.setTextColor(ContextCompat.getColor(this,R.color.md_white_1000));
            femaleLayout.setBackgroundResource(0);
            female.setTextColor(ContextCompat.getColor(this,R.color.md_green_600));
            maleIcon.setImageResource(R.drawable.ic_male_white);
            femaleIcon.setImageResource(R.drawable.ic_female_green);
        } else {
            femaleLayout.setBackground(ContextCompat.getDrawable(this,R.drawable.rectangle_background_filled_gender));
            female.setBackgroundResource(0);
            female.setTextColor(ContextCompat.getColor(this,R.color.md_white_1000));
            maleLayout.setBackgroundResource(0);
            male.setTextColor(ContextCompat.getColor(this,R.color.md_green_600));
            maleIcon.setImageResource(R.drawable.ic_male_green);
            femaleIcon.setImageResource(R.drawable.ic_female_white);
        }
    }
    //endregion
}

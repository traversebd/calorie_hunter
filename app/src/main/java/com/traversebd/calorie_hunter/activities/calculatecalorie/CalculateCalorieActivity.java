package com.traversebd.calorie_hunter.activities.calculatecalorie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.shawnlin.numberpicker.NumberPicker;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;

public class CalculateCalorieActivity extends AppCompatActivity {
    private RelativeLayout maleLayout, femaleLayout;
    private TextView male,female;
    private ImageView maleIcon, femaleIcon;
    private Button calculateButton;
    private EditText age;
    private NumberPicker weight, height;
    private IndicatorSeekBar activityLevelSeekBar;
    private int heightInt, weightInt, ageInt, activityLevelId;
    private String gender;
    private LinearLayout dialogLayout;
    private Dialog itemDialog;

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
        maleLayout = findViewById(R.id.maleLayout);
        femaleLayout = findViewById(R.id.femaleLayout);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
        maleIcon = findViewById(R.id.MaleIcon);
        femaleIcon = findViewById(R.id.FemaleIcon);
        calculateButton = findViewById(R.id.calculateButton);
        age = findViewById(R.id.Age);
        weight = findViewById(R.id.Weight);
        height = findViewById(R.id.Height);
        activityLevelSeekBar = findViewById(R.id.ActivityLevelSeekBar);
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
                gender = getString(R.string.male);
                changeGender(getString(R.string.male));
            }
        });
        femaleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = getString(R.string.female);
                changeGender(getString(R.string.female));
            }
        });
        //endregion

        //region height and width number picker
        height.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                heightInt = newVal;
            }
        });

        weight.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                weightInt = newVal;
            }
        });
        //endregion

        //region activity level seekBar
        activityLevelSeekBar.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
                activityLevelId = seekBar.getTickCount();
            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {

            }
        });
        //endregion

        //region calculate button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateData()){
                    showDialog();
                }
                else{
                    Toast.makeText(CalculateCalorieActivity.this, "Please check all field data", Toast.LENGTH_SHORT).show();
                }
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

    //region validation
    private boolean validateData(){
        boolean isValid = false;
        if (!TextUtils.isEmpty(age.getText().toString())) {
            ageInt = Integer.parseInt(age.getText().toString());
            isValid = true;
        }
        else if (heightInt !=0){
            isValid = true;
        }
        else if (weightInt !=0){
            isValid = true;
        }
        else if (activityLevelId !=0){
            isValid = true;
        }
        else if (!TextUtils.isEmpty(gender)){
            isValid = true;
        }
        return isValid;
    }
    //endregion

    //region show result dialog
    private void showDialog() {
        itemDialog = new Dialog(this);
        itemDialog.setContentView(R.layout.dialog_calorie_result);
        dialogInit();
        itemDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Animation a = AnimationUtils.loadAnimation(itemDialog.getContext(), R.anim.push_up_in);
        dialogLayout.startAnimation(a);
        itemDialog.show();
    }
    //endregion

    //region init all dialog components
    private void dialogInit() {
        dialogLayout = itemDialog.findViewById(R.id.dialogLayout);
    }
    //endregion

    //region back pressed
    @Override
    public void onBackPressed() {
        startActivity(new Intent(CalculateCalorieActivity.this, HomeActivity.class));
    }
    //endregion
}

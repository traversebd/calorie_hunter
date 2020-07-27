package com.traversebd.calorie_hunter.activities.base;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.amitshekhar.DebugDB;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.tour.TourPageActivity;
import com.traversebd.calorie_hunter.utils.AllFileManager;
import com.traversebd.calorie_hunter.utils.PrefManager;
import static com.traversebd.calorie_hunter.utils.Constants.mAlreadyVisited;

public class SplashActivity extends AppCompatActivity {
    private Animation topAnim, middleAnim, bottomAnim;
    private View first,second,third,fourth,fifth;
    private TextView AppName, DevelopedBy, Developer;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //region init components and their interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init XML components with backend
    private void initUI() {
        first = findViewById(R.id.FirstLine);
        second = findViewById(R.id.SecondLine);
        third = findViewById(R.id.ThirdLine);
        fourth = findViewById(R.id.FourthLine);
        fifth = findViewById(R.id.FifthLine);
        AppName = findViewById(R.id.AppName);
        DevelopedBy = findViewById(R.id.DevelopedBy);
        Developer = findViewById(R.id.DeveloperName);
        prefManager = new PrefManager(this);
    }
    //endregion

    //region perform UI interactions
    private void bindUIWithComponents() {

        //region get db log browser address
        Log.v("Shakil - DB Browser", DebugDB.getAddressLog());
        //Toast.makeText(getApplicationContext(),"Shakil - DB Browser"+DebugDB.getAddressLog(),Toast.LENGTH_LONG).show();
        //endregion

        setAnimation();
        loadAnimationForUI();

        //region splash screen code to call new activity after some time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (prefManager.getBoolean(mAlreadyVisited)) {
                    intent = new Intent(SplashActivity.this, HomeActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, TourPageActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
    //endregion

    //region set animation
    private void setAnimation() {
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim_splash);
        middleAnim = AnimationUtils.loadAnimation(this,R.anim.middle_anim_splash);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim_splash);
    }
    //endregion

    //region load animation into UI components
    private void loadAnimationForUI() {
        first.setAnimation(topAnim);
        second.setAnimation(topAnim);
        third.setAnimation(topAnim);
        fourth.setAnimation(topAnim);
        fifth.setAnimation(topAnim);

        AppName.setAnimation(middleAnim);
        DevelopedBy.setAnimation(bottomAnim);
        Developer.setAnimation(bottomAnim);
    }
    //endregion
}

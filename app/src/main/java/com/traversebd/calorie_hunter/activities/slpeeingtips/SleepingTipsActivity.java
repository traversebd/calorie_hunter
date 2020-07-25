package com.traversebd.calorie_hunter.activities.slpeeingtips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.adapters.SleepingDurationListAdapter;
import com.traversebd.calorie_hunter.models.sleepingtips.SleepingTips;
import java.util.ArrayList;

public class SleepingTipsActivity extends AppCompatActivity {
    private RecyclerView hoursToSleepRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleeping_tips);

        //region init and bind all UI operations
        initUI();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void initUI() {
        hoursToSleepRecycler = findViewById(R.id.hoursToSleepRecycler);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SleepingTipsActivity.this, HomeActivity.class));
            }
        });
        //endregion

        //region set hours to sleep adapter
        setHoursToSleepAdapter();
        //endregion
    }
    //endregion

    //region get age and hours to sleep list data
    private ArrayList<SleepingTips> getSleepingTipsData(){
        ArrayList<SleepingTips> sleepingTips = new ArrayList<>();
        sleepingTips.add(new SleepingTips("0–3 months","14–17"));
        sleepingTips.add(new SleepingTips("4 months to 2 years","11–16"));
        sleepingTips.add(new SleepingTips("3–5 years","10–13"));
        sleepingTips.add(new SleepingTips("6–13 years","9–12"));
        sleepingTips.add(new SleepingTips("14–17 years","8–10"));
        sleepingTips.add(new SleepingTips("18–64 years","7–9"));
        sleepingTips.add(new SleepingTips("65 years and over","7–8"));
        return sleepingTips;
    }
    //endregion

    //region set adapter
    private void setHoursToSleepAdapter(){
        SleepingDurationListAdapter durationListAdapter = new SleepingDurationListAdapter(getSleepingTipsData());
        hoursToSleepRecycler.setLayoutManager(new LinearLayoutManager(this));
        hoursToSleepRecycler.setAdapter(durationListAdapter);
        durationListAdapter.notifyDataSetChanged();
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(SleepingTipsActivity.this, HomeActivity.class));
    }
    //endregion
}
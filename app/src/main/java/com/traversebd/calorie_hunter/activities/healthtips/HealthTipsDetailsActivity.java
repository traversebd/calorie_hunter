package com.traversebd.calorie_hunter.activities.healthtips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.adapters.HealthDetailTipsAdapter;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;
import java.util.HashMap;
import java.util.Locale;

public class HealthTipsDetailsActivity extends AppCompatActivity {

    private ImageView listenIcon;
    private TextView collectionDate, description, shortDescription;
    private TextToSpeech textToSpeech;
    private boolean isTextToSpeechOn = false;
    private RecyclerView allHealthTipsRecycler;
    private HealthTips healthTips;
    private LinearLayout detailsTipsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips_details);

        //region load extra data
        loadTips();
        //endregion

        //region init and bind all UI operations
        init();
        bindUiWithComponents();
        //endregion
    }

    //region load data from intent
    private void loadTips(){
        if (getIntent().getSerializableExtra("tips") != null){
            healthTips = (HealthTips) getIntent().getSerializableExtra("tips");
        }
    }
    //endregion

    //region all init operation
    private void init() {
        listenIcon = findViewById(R.id.listenIcon);
        allHealthTipsRecycler = findViewById(R.id.detailTipsRecycler);
        collectionDate = findViewById(R.id.CollectionDate);
        shortDescription = findViewById(R.id.ShortDescription);
        description = findViewById(R.id.Description);
        detailsTipsLayout = findViewById(R.id.detailsTipsLayout);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthTipsDetailsActivity.this, HealthTipsListActivity.class));
            }
        });
        //endregion

        //region init text to speech
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.US);
                textToSpeech.setSpeechRate(0.7f);
                textToSpeech.setPitch(1);
            }
        });
        //endregion

        //region listen icon click listener
        listenIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenToHealthTips();
            }
        });
        //endregion

        //region call detailed recycler adapter
        if (getCommaSeparatedItems() != null && getCommaSeparatedItems().length > 0) {
            setDetailsRecycler();
        }
        else{
            detailsTipsLayout.setVisibility(View.GONE);
        }
        //endregion
    }
    //endregion

    //region set recycler for details tips
    private void setDetailsRecycler(){
        HealthDetailTipsAdapter detailTipsAdapter = new HealthDetailTipsAdapter(getCommaSeparatedItems());
        allHealthTipsRecycler.setLayoutManager(new LinearLayoutManager(this));
        allHealthTipsRecycler.setAdapter(detailTipsAdapter);
        detailTipsAdapter.notifyDataSetChanged();
    }
    //endregion

    //region comma separated tips item
    private String[] getCommaSeparatedItems(){
        String[] extraDetails = null;

        if (healthTips.getDetailsTips() != null){
            extraDetails = healthTips.getDetailsTips().split(";");
        }
        return extraDetails;
    }
    //endregion

    //region start play or stop the playing voice
    private void listenToHealthTips() {
        if (isTextToSpeechOn) {
            textToSpeech.stop();
            listenIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_record_voice_over));
            isTextToSpeechOn = false;
            Toast.makeText(getApplicationContext(), "Text to Speech Stopped", Toast.LENGTH_SHORT).show();
        }
        else {
            String text = "Collection date is"+ collectionDate.getText().toString() + "Now you will hear short description "+shortDescription.getText().toString()+
                    "Its time for long description "+description.getText().toString();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ttsGreater21(text);
            } else {
                ttsUnder20(text);
            }
            listenIcon.setImageResource(R.drawable.ic_stop);
            isTextToSpeechOn = true;
            Toast.makeText(getApplicationContext(), "Text to Speech Started", Toast.LENGTH_SHORT).show();
        }
    }
    //endregion

    //region text to speech speak for different api level
    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId = this.hashCode() + "";
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(HealthTipsDetailsActivity.this, HealthTipsListActivity.class));
    }
    //endregion
}

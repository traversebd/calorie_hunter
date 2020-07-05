package com.traversebd.calorie_hunter.activities.healthtips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.traversebd.calorie_hunter.R;
import java.util.HashMap;
import java.util.Locale;

public class HealthTipsDetailsActivity extends AppCompatActivity {

    private ImageView listenIcon;
    private TextView listenHint,collectionDate, description, shortDescription;
    private TextToSpeech textToSpeech;
    private boolean isTextToSpeechOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips_details);

        //region init and bind all UI operations
        init();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void init() {
        listenIcon = findViewById(R.id.listenIcon);
        listenHint = findViewById(R.id.listenHint);
        collectionDate = findViewById(R.id.CollectionDate);
        shortDescription = findViewById(R.id.ShortDescription);
        description = findViewById(R.id.Description);
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
    }
    //endregion

    //region comma separated tips item
    private void getCommaSeparatedItems(){

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
            listenIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_record_voice_over));
            isTextToSpeechOn = true;
            Toast.makeText(getApplicationContext(), "Text to Speech Started", Toast.LENGTH_SHORT).show();
        }
    }
    //endregion

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

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(HealthTipsDetailsActivity.this, HealthTipsListActivity.class));
    }
    //endregion
}

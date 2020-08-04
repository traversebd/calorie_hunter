package com.traversebd.calorie_hunter.activities.nutritiontips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.adapters.NutritionDetailTipsAdapter;
import com.traversebd.calorie_hunter.models.nutritiontips.NutritionTips;
import java.util.ArrayList;

public class NutritionTipsDetailsActivity extends AppCompatActivity {
    private int nutritionTypeId;
    private NutritionTips nutritionTips;
    private RecyclerView allNutritionTipsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_tips_details);

        //region init and bind all UI operations
        initUI();
        bindUiWithComponents();
        //endregion
    }

    //region all init operation
    private void initUI() {
        allNutritionTipsRecycler = findViewById(R.id.detailTipsRecycler);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents() {
        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NutritionTipsDetailsActivity.this, NutritionTipsListActivity.class));
            }
        });
        //endregion

        //region load intent data
        loadIntentData();
        //endregion

        //region set data
        nutritionTips = setNutritionTips();
        //endregion

        //region set nutrition tips details recycler
        setDetailsRecycler();
        //endregion
    }
    //endregion

    //region load data
    private void loadIntentData() {
        if (getIntent().getIntExtra("typeId",0) != 0) {
            nutritionTypeId = getIntent().getIntExtra("typeId",0);
        }
        else{
            Toast.makeText(getApplicationContext(),getString(R.string.no_data_found),Toast.LENGTH_LONG).show();
        }
    }
    //endregion

    //region set nutrition tips data
    private NutritionTips setNutritionTips(){
        NutritionTips nutritionTips = new NutritionTips();
        nutritionTips.setId(1);
        nutritionTips.setNutritionTypeId(1);
        nutritionTips.setNutritionTypeTitle("Portion Control");
        if (nutritionTypeId == 1) {
            nutritionTips.setDetailTipsList(setPortionDetailsData());
        }
        else if (nutritionTypeId == 2) {
            nutritionTips.setDetailTipsList(setListeningBodyDetailsData());
        }
        else if (nutritionTypeId == 3) {
            nutritionTips.setDetailTipsList(setMoreFiberDetailsData());
        }
        else if (nutritionTypeId == 4) {
            nutritionTips.setDetailTipsList(setGeneralTipsDetailsData());
        }
        return nutritionTips;
    }
    //endregion

    //region set details tips list
    private ArrayList<String> setPortionDetailsData(){
        ArrayList<String> detailTipsList = new ArrayList<>();
        detailTipsList.add("Drink a glass of water before you eat, and drink more water during meals.");
        detailTipsList.add("Consider using smaller plates, bowls, glasses and serving spoons.");
        detailTipsList.add("Do not put serving dishes on the table – this reduces the urge to easily grab “seconds.”");
        detailTipsList.add("Try dividing your plate into four equal parts: one for meat, one for starch (pasta, rice, potatoes or bread) and two for non-starchy vegetables.");
        detailTipsList.add("Eat slowly. Take a few one-minute breaks from eating during meals, and put your fork down between bites.");
        return detailTipsList;
    }

    private ArrayList<String> setListeningBodyDetailsData(){
        ArrayList<String> detailTipsList = new ArrayList<>();
        detailTipsList.add("Pay attention to your body. When you feel as though you’ve had enough to eat, stop! Quit before you feel full or “stuffed.”");
        detailTipsList.add("If you still feel hungry or unsatisfied after a meal or snack, wait at least 10 minutes before you have more, giving your body time to signal you that you’re satisfied. ");
        detailTipsList.add("Are you hungry, or are you thirsty? Drink plenty of calorie-free drinks such as water, tea, coffee or diet soda. You may just be thirsty rather than hungry.”");
        detailTipsList.add("Consider removing your plate as soon as you finish eating, avoiding the temptation to have seconds.");
        return detailTipsList;
    }

    private ArrayList<String> setMoreFiberDetailsData(){
        ArrayList<String> detailTipsList = new ArrayList<>();
        detailTipsList.add("Try to get plenty of fiber in your diet – 20 to 30 grams every day!");
        detailTipsList.add("Soluble fiber (think cucumbers, blueberries, beans and nuts) dissolves into a gel-like texture, helping to slow down your digestion so that you feel fuller, longer.");
        detailTipsList.add("Insoluble fiber (think dark green leafy vegetables, green beans, celery and carrots) does not dissolve at all and helps add bulk to your stool and move food through your digestive tract more quickly.”");
        detailTipsList.add("Vegetables, fruits, whole grains and legumes (beans) are good sources of fiber.");
        detailTipsList.add("Try having a high-fiber cereal every day for breakfast – there are LOTS of varieties from which to choose.");
        return detailTipsList;
    }

    private ArrayList<String> setGeneralTipsDetailsData(){
        ArrayList<String> detailTipsList = new ArrayList<>();
        detailTipsList.add("Want something sweet? Enjoy fruit for dessert!");
        detailTipsList.add("Having a salad? Put salad dressing on the side and dip your fork into the dressing before you spear a bite of salad.");
        detailTipsList.add("Try to keep all food in the kitchen. Eat only in a chosen place (such as the table), and avoid eating in front of the TV or “mindless” eating.”");
        detailTipsList.add("Choose lean meats, low-fat or nonfat cheese, and fat-free (skim) or low-fat (1 percent) milk over their higher-fat counterparts.");
        detailTipsList.add("Try replacing one soda or sugary drink a day with water. Many sodas offer 290-plus calories, 42 grams of sugar and up to 50 milligrams of sodium!");
        detailTipsList.add("Flavor your water naturally with a lemon slice, a lime wedge or even cucumber slices.");
        return detailTipsList;
    }
    //endregion

    //region set recycler for details tips
    private void setDetailsRecycler(){
        NutritionDetailTipsAdapter detailTipsAdapter = new NutritionDetailTipsAdapter(nutritionTips.getDetailTipsList());
        allNutritionTipsRecycler.setLayoutManager(new LinearLayoutManager(this));
        allNutritionTipsRecycler.setAdapter(detailTipsAdapter);
        detailTipsAdapter.notifyDataSetChanged();
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(NutritionTipsDetailsActivity.this, NutritionTipsListActivity.class));
    }
    //endregion
}

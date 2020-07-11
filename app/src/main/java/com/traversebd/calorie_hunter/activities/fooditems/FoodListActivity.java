package com.traversebd.calorie_hunter.activities.fooditems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.base.HomeActivity;
import com.traversebd.calorie_hunter.adapters.CategorizedFoodAdapter;
import com.traversebd.calorie_hunter.db.food.FoodViewModel;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.traversebd.calorie_hunter.utils.layoutmanager.VegaLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {
    private List<FoodItem> allFoodItems = new ArrayList<>();
    private static int foodType;
    private TextView totalItems, foodTypeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //region all works related to this activity
        init();
        bindUiWithComponents();
        //endregion
    }

    //region init all UI with backend
    private void init(){
        totalItems = findViewById(R.id.TotalItems);
        foodTypeTitle = findViewById(R.id.FoodTypeTitle);
    }
    //endregion

    //region perform all UI interactions
    private void bindUiWithComponents(){
        //region load intent data
        loadExtra();
        //endregion

        //region get all food items
        FoodViewModel foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        foodViewModel.getAllFoodItems().observe(this, new Observer<List<FoodItem>>() {
            @Override
            public void onChanged(List<FoodItem> foodItems) {
                allFoodItems = foodItems;
                totalItems.setText(""+prepareDataList().size());
                setFoodRecycler();
            }
        });
        //endregion

        //region back button
        findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodListActivity.this,HomeActivity.class));
            }
        });
        //endregion

        //region set top bar details
        foodTypeTitle.setText(getFoodTypeTitle());
        //endregion
    }

    //region load intent data
    private void loadExtra(){
        foodType = 0;
        if (getIntent().getIntExtra("foodType",0) != 0){
            foodType = getIntent().getIntExtra("foodType",0);
        }
    }
    //endregion

    //region set food recycler
    private void setFoodRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.allFoodRecycler);
        recyclerView.setLayoutManager(new VegaLayoutManager());
        CategorizedFoodAdapter adapter = new CategorizedFoodAdapter(prepareDataList(),this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    //endregion

    //region get data list
    private ArrayList<FoodItem> prepareDataList() {
        ArrayList<FoodItem> categorizedFoodList =new ArrayList<>();
        for (int start = 0; start < allFoodItems.size(); start++) {
            if (allFoodItems.get(start).getFoodTypeId() == foodType){
                categorizedFoodList.add(allFoodItems.get(start));
            }
        }
        return categorizedFoodList;
    }
    //end region

    //region get food type title
    private String getFoodTypeTitle(){
        String foodTypeTitle = "";
        if (foodType == 1) foodTypeTitle = "Breakfast";
        else if (foodType == 2) foodTypeTitle = "Lunch";
        else if (foodType == 3) foodTypeTitle = "Snacks";
        else if (foodType == 4) foodTypeTitle = "Dinner";
        return foodTypeTitle;
    }
    //endregion

    //region all system callbacks and methods
    @Override
    public void onBackPressed() {
        startActivity(new Intent(FoodListActivity.this, HomeActivity.class));
    }
    //endregion
}

package com.traversebd.calorie_hunter.activities.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.activities.fooditems.FoodListActivity;
import com.traversebd.calorie_hunter.adapters.FoodRecyclerAdapter;
import com.traversebd.calorie_hunter.adapters.NavDrawerRecyclerAdapter;
import com.traversebd.calorie_hunter.db.food.FoodViewModel;
import com.traversebd.calorie_hunter.models.drawer.NavDrawer;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private SlidingRootNav slidingRootNav;
    private RecyclerView navRecycler, morningRecycler, lunchRecycler, snacksRecycler, dinnerRecycler;
    private List<FoodItem> allFoodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //region init sliding nav drawer
        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(null)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();
        //endregion

        //region init components and perform UI interactions
        init();
        bindUIWithComponents();
        //endregion
    }

    //region init XML components with backend
    private void init() {
        navRecycler = findViewById(R.id.list);
        morningRecycler = findViewById(R.id.morningRecycler);
        lunchRecycler = findViewById(R.id.lunchRecycler);
        snacksRecycler = findViewById(R.id.snacksRecycler);
        dinnerRecycler = findViewById(R.id.dinnerRecycler);
        allFoodItems = new ArrayList<>();
    }
    //endregion

    //region perform UI interactions
    private void bindUIWithComponents() {
        //region get all food items
        FoodViewModel foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        foodViewModel.getAllFoodItems().observe(this, new Observer<List<FoodItem>>() {
            @Override
            public void onChanged(List<FoodItem> foodItems) {
                allFoodItems = foodItems;

                //region set morning list adapter
                setMorningListAdapter();
                //endregion

                //region set lunch list adapter
                setLunchListAdapter();
                //endregion

                //region set snacks list adapter
                setSnacksListAdapter();
                //endregion

                //region set dinner list adapter
                setDinnerListAdapter();
                //endregion
            }
        });
        //endregion

        //region set drawer adapter
        setDrawerAdapter();
        //endregion

        //region drawer humberger icon
        findViewById(R.id.DrawerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(slidingRootNav.isMenuClosed()) {
                    slidingRootNav.openMenu();
                }
                else {
                    slidingRootNav.closeMenu();
                }
            }
        });
        //endregion
    }
    //endregion

    //region set drawer adapter
    private void setDrawerAdapter() {
        NavDrawerRecyclerAdapter drawerRecyclerAdapter = new NavDrawerRecyclerAdapter(this,getDrawerItem());
        navRecycler.setLayoutManager(new LinearLayoutManager(this));
        navRecycler.setAdapter(drawerRecyclerAdapter);
        drawerRecyclerAdapter.notifyDataSetChanged();

        //region drawer item click listener
        drawerRecyclerAdapter.setOnItemClickListener(new NavDrawerRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(NavDrawer navDrawer) {

            }
        });
        //endregion
    }
    //endregion

    //region set morning list adapter
    private void setMorningListAdapter() {
        FoodRecyclerAdapter foodRecyclerAdapter = new FoodRecyclerAdapter(this,getMorningFoodItem());
        morningRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        morningRecycler.setAdapter(foodRecyclerAdapter);
        foodRecyclerAdapter.notifyDataSetChanged();

        //region morning recycler item click listener
        foodRecyclerAdapter.setOnItemClickListener(new FoodRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(FoodItem foodItem) {
                startActivity(new Intent(HomeActivity.this, FoodListActivity.class).putExtra("foodType",foodItem.getFoodTypeId()));
            }
        });
        //endregion
    }
    //endregion

    //region set snacks list adapter
    private void setLunchListAdapter() {
        FoodRecyclerAdapter foodRecyclerAdapter = new FoodRecyclerAdapter(this,getLunchFoodItem());
        lunchRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        lunchRecycler.setAdapter(foodRecyclerAdapter);
        foodRecyclerAdapter.notifyDataSetChanged();

        //region lunch recycler item click listener
        foodRecyclerAdapter.setOnItemClickListener(new FoodRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(FoodItem foodItem) {
                startActivity(new Intent(HomeActivity.this, FoodListActivity.class).putExtra("foodType",foodItem.getFoodTypeId()));
            }
        });
        //endregion
    }
    //endregion

    //region set drawer adapter
    private void setSnacksListAdapter() {
        FoodRecyclerAdapter foodRecyclerAdapter = new FoodRecyclerAdapter(this,getSnacksFoodItem());
        snacksRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        snacksRecycler.setAdapter(foodRecyclerAdapter);
        foodRecyclerAdapter.notifyDataSetChanged();

        //region snacks recycler item click listener
        foodRecyclerAdapter.setOnItemClickListener(new FoodRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(FoodItem foodItem) {
                startActivity(new Intent(HomeActivity.this, FoodListActivity.class).putExtra("foodType",foodItem.getFoodTypeId()));
            }
        });
        //endregion
    }
    //endregion

    //region set dinner list adapter
    private void setDinnerListAdapter() {
        FoodRecyclerAdapter foodRecyclerAdapter = new FoodRecyclerAdapter(this,getDinnerFoodItem());
        dinnerRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        dinnerRecycler.setAdapter(foodRecyclerAdapter);
        foodRecyclerAdapter.notifyDataSetChanged();

        //region dinner recycler item click listener
        foodRecyclerAdapter.setOnItemClickListener(new FoodRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(FoodItem foodItem) {
                startActivity(new Intent(HomeActivity.this, FoodListActivity.class).putExtra("foodType",foodItem.getFoodTypeId()));
            }
        });
        //endregion
    }
    //endregion

    //region get drawer list items
    private ArrayList<NavDrawer> getDrawerItem() {
        ArrayList<NavDrawer> items = new ArrayList<>();
        items.add(new NavDrawer(R.drawable.ic_meal_plan,getString(R.string.meal_plan)));
        items.add(new NavDrawer(R.drawable.ic_health_tips,getString(R.string.health_tips)));
        items.add(new NavDrawer(R.drawable.ic_nutrition_tips,getString(R.string.nutrition_tips)));
        items.add(new NavDrawer(R.drawable.ic_sleep_time,getString(R.string.sleeping_tips)));
        items.add(new NavDrawer(R.drawable.ic_calories_calculator,getString(R.string.calculate_calorie)));
        return items;
    }
    //endregion

    //region get morning food items
    private ArrayList<FoodItem> getMorningFoodItem() {
        ArrayList<FoodItem> items = new ArrayList<>();
        for (FoodItem foodItem : allFoodItems){
            if (foodItem.getFoodTypeId() == 1){
                items.add(foodItem);
            }
        }
            return items;
    }
    //endregion

    //region get lunch food items
    private ArrayList<FoodItem> getLunchFoodItem() {
        ArrayList<FoodItem> items = new ArrayList<>();
        for (FoodItem foodItem : allFoodItems){
            if (foodItem.getFoodTypeId() == 2){
                items.add(foodItem);
            }
        }
        return items;
    }
    //endregion

    //region get snacks food items
    private ArrayList<FoodItem> getSnacksFoodItem() {
        ArrayList<FoodItem> items = new ArrayList<>();
        for (FoodItem foodItem : allFoodItems){
            if (foodItem.getFoodTypeId() == 3){
                items.add(foodItem);
            }
        }
        return items;
    }
    //endregion

    //region get dinner food items
    private ArrayList<FoodItem> getDinnerFoodItem() {
        ArrayList<FoodItem> items = new ArrayList<>();
        for (FoodItem foodItem : allFoodItems){
            if (foodItem.getFoodTypeId() == 4){
                items.add(foodItem);
            }
        }
        return items;
    }
    //endregion
}

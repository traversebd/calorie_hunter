package com.traversebd.calorie_hunter.activities.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.adapters.NavDrawerRecyclerAdapter;
import com.traversebd.calorie_hunter.models.NavDrawer;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    SlidingRootNav slidingRootNav;
    NavDrawerRecyclerAdapter drawerRecyclerAdapter;
    RecyclerView navRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init XML components with backend
    private void initUI() {
        navRecyclerView = findViewById(R.id.list);
    }
    //endregion

    //region perform UI interactions
    private void bindUIWithComponents() {
        setDataAdapter();
        drawerRecyclerAdapter.setOnItemClickListener(new NavDrawerRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(NavDrawer navDrawer) {

            }
        });

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
    }
    //endregion

    //region set drawer adapter
    private void setDataAdapter() {
        drawerRecyclerAdapter = new NavDrawerRecyclerAdapter(this,getDrawerItem());
        navRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        navRecyclerView.setAdapter(drawerRecyclerAdapter);
        drawerRecyclerAdapter.notifyDataSetChanged();
    }
    //endregion

    //region get drawer list items
    private ArrayList<NavDrawer> getDrawerItem() {
        ArrayList<NavDrawer> items = new ArrayList<>();
        items.add(new NavDrawer(R.drawable.ic_meal_plan,getString(R.string.meal_plan)));
        items.add(new NavDrawer(R.drawable.ic_health_tips,getString(R.string.health_tips)));
        items.add(new NavDrawer(R.drawable.ic_nutrition_tips,getString(R.string.nutrition_tips)));
        items.add(new NavDrawer(R.drawable.ic_calories_calculator,getString(R.string.calculate_calorie)));
        return items;
    }
    //endregion
}

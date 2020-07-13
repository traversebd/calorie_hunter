package com.traversebd.calorie_hunter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import com.traversebd.calorie_hunter.models.mealplan.CustomMealPlanList;
import java.util.ArrayList;
import java.util.List;

public class MealPlanListAdapter extends RecyclerView.Adapter<MealPlanListAdapter.ViewHolder> {
    private ArrayList<CustomMealPlanList> allItems;

    public MealPlanListAdapter(ArrayList<CustomMealPlanList> allItems) {
        this.allItems = allItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_all_meal_plan_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomMealPlanList mealPlan = allItems.get(position);
        holder.Counter.setText(""+(position+1));
        holder.DayOfWeek.setText(mealPlan.getDayOfWeek());
        //region get and set food item texts
        holder.FoodItem.setText(setFoodItemTexts(mealPlan.getAllFoodItems()));
        //endregion
        holder.AmountOfCalorie.setText("");
        //region get and set total calorie
        holder.AmountOfCalorie.setText(""+getTotalCalorie(mealPlan.getAllFoodItems()));
        //endregion
    }

    //region calculate total calorie
    private String setFoodItemTexts(List<FoodItem> allFoodItems) {
        String texts = "";
        for (int start = 0; start < allFoodItems.size(); start++) {
            if (start == allFoodItems.size()-1){
                texts+= ","+allFoodItems.get(start).getTitle();
            }
            else{
                texts+= ""+allFoodItems.get(start).getTitle();
            }
        }
        return texts;
    }
    //endregion

    //region calculate total calorie
    private double getTotalCalorie(List<FoodItem> allFoodItems) {
        double totalCalorie = 0;
        for (int start = 0; start < allFoodItems.size(); start++) {
            totalCalorie += allFoodItems.get(start).getAmountOfCalorie();
        }
        return totalCalorie;
    }
    //endregion

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Counter, DayOfWeek, FoodItem, AmountOfCalorie;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Counter = itemView.findViewById(R.id.Counter);
            DayOfWeek = itemView.findViewById(R.id.DayOfWeek);
            FoodItem = itemView.findViewById(R.id.FoodItem);
            AmountOfCalorie = itemView.findViewById(R.id.AmountOfCalorie);
        }
    }
}

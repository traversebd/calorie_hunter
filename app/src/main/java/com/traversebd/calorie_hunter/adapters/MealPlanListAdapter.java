package com.traversebd.calorie_hunter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.mealplan.MealPlan;
import java.util.ArrayList;

public class MealPlanListAdapter extends RecyclerView.Adapter<MealPlanListAdapter.ViewHolder> {
    private ArrayList<MealPlan> allItems;

    public MealPlanListAdapter(ArrayList<MealPlan> allItems) {
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
        MealPlan mealPlan = allItems.get(position);
        holder.Counter.setText(""+(position+1));
        holder.DayOfWeek.setText(mealPlan.getDayOfWeek());
        holder.FoodItem.setText("");
        holder.AmountOfCalorie.setText("");
    }

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

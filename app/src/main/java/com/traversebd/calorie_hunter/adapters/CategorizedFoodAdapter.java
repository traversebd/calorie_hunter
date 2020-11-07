package com.traversebd.calorie_hunter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import java.util.ArrayList;

public class CategorizedFoodAdapter extends RecyclerView.Adapter<CategorizedFoodAdapter.ViewHolder> {
    private ArrayList<FoodItem> allItems;
    private Context context;
    private onItemClickListener onItemClickListener;

    public CategorizedFoodAdapter(ArrayList<FoodItem> allItems, Context context) {
        this.allItems = allItems;
        this.context = context;
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick(FoodItem foodItem);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_recycler_all_food_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FoodItem foodItem = allItems.get(position);
        holder.Title.setText(foodItem.getTitle());
        holder.AmountOfCalorie.setText("" + foodItem.getAmountOfCalorie());
        holder.FoodShortDescription.setText(foodItem.getFoodShortDescription());
        holder.Icon.setImageResource(foodItem.getIcon());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(foodItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Title;
        TextView AmountOfCalorie;
        TextView FoodShortDescription;
        ImageView Icon;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.item_card_view);
            Title = (TextView) itemView.findViewById(R.id.Title);
            AmountOfCalorie = (TextView) itemView.findViewById(R.id.AmountOfCalorie);
            FoodShortDescription = (TextView) itemView.findViewById(R.id.FoodShortDescription);
            Icon = (ImageView) itemView.findViewById(R.id.Icon);
        }
    }
}

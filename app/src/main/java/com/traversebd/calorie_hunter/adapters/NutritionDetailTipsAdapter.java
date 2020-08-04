package com.traversebd.calorie_hunter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.traversebd.calorie_hunter.R;
import java.util.ArrayList;

public class NutritionDetailTipsAdapter extends RecyclerView.Adapter<NutritionDetailTipsAdapter.ViewHolder> {
    private ArrayList<String> extraDetails;

    public NutritionDetailTipsAdapter(ArrayList<String> extraDetails) {
        this.extraDetails = extraDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_nutrition_tips_detail_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.DetailsItem.setText(extraDetails.get(position));
    }

    @Override
    public int getItemCount() {
        return extraDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView DetailsItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            DetailsItem = (TextView) itemView.findViewById(R.id.DetailsItem);
        }
    }
}

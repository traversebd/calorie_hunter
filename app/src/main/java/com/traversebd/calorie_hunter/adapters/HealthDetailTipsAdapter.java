package com.traversebd.calorie_hunter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.traversebd.calorie_hunter.R;

public class HealthDetailTipsAdapter extends RecyclerView.Adapter<HealthDetailTipsAdapter.ViewHolder> {
    private String[] extraDetails;

    public HealthDetailTipsAdapter(String[] extraDetails) {
        this.extraDetails = extraDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_health_tips_details_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.DetailsItem.setText(extraDetails[position]);
        holder.SerialNumber.setText(""+(position+1));
    }

    @Override
    public int getItemCount() {
        return extraDetails.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView DetailsItem, SerialNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            DetailsItem = (TextView) itemView.findViewById(R.id.DetailsItem);
            SerialNumber = (TextView) itemView.findViewById(R.id.SerialNumber);
        }
    }
}

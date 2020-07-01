package com.traversebd.calorie_hunter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;
import java.util.ArrayList;

public class HealthTipsSliderAdapter extends RecyclerView.Adapter<HealthTipsSliderAdapter.SliderAdapterVH> {

    private ArrayList<HealthTips> healthTipsList;
    private Context context;
    private onItemClick onItemClick;

    public HealthTipsSliderAdapter(ArrayList<HealthTips> healthTipsList, Context context) {
        this.healthTipsList = healthTipsList;
        this.context = context;
    }

    public void onItemClickListener(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

    public interface onItemClick{
        void itemClick(HealthTips healthTips);
    }

    @NonNull
    @Override
    public SliderAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_health_tips_list, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        final HealthTips itemModel = healthTipsList.get(position);

        //onClick listener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.itemClick(itemModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return healthTipsList.size();
    }

    public static class SliderAdapterVH extends RecyclerView.ViewHolder {

        View itemView;
        TextView Title,Amount,TotalCost,Position, WalletType,ExpiresOn, TotalHeading, RemainingHeading;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
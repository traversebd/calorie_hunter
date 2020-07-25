package com.traversebd.calorie_hunter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.traversebd.calorie_hunter.R;
import com.traversebd.calorie_hunter.models.sleepingtips.SleepingTips;
import java.util.ArrayList;

public class SleepingDurationListAdapter extends RecyclerView.Adapter<SleepingDurationListAdapter.ViewHolder> {
    private ArrayList<SleepingTips> allItems;

    public SleepingDurationListAdapter(ArrayList<SleepingTips> allItems) {
        this.allItems = allItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_sleeping_duration_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SleepingTips sleepingTips = allItems.get(position);
        holder.Age.setText(sleepingTips.getAge());
        holder.HoursToSleep.setText(sleepingTips.getHoursToSleep());
    }

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Age;
        TextView HoursToSleep;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Age = (TextView) itemView.findViewById(R.id.Age);
            HoursToSleep = (TextView) itemView.findViewById(R.id.HoursToSleep);
        }
    }
}

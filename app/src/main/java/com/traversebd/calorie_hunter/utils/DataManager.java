package com.traversebd.calorie_hunter.utils;

import android.content.Context;

public class DataManager {
    private Context context;
    private UX ux;

    public DataManager(Context context) {
        this.context = context;
        ux = new UX(context);
    }

}

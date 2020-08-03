package com.traversebd.calorie_hunter.models.nutritiontips;

import java.util.ArrayList;

public class NutritionTips {
    private int id;
    private int NutritionTypeId;
    private String NutritionTypeTitle;
    private ArrayList<String> DetailTipsList;

    public NutritionTips(int id, int nutritionTypeId, String nutritionTypeTitle, ArrayList<String> detailTipsList) {
        this.id = id;
        NutritionTypeId = nutritionTypeId;
        NutritionTypeTitle = nutritionTypeTitle;
        DetailTipsList = detailTipsList;
    }

    public NutritionTips() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNutritionTypeId() {
        return NutritionTypeId;
    }

    public void setNutritionTypeId(int nutritionTypeId) {
        NutritionTypeId = nutritionTypeId;
    }

    public String getNutritionTypeTitle() {
        return NutritionTypeTitle;
    }

    public void setNutritionTypeTitle(String nutritionTypeTitle) {
        NutritionTypeTitle = nutritionTypeTitle;
    }

    public ArrayList<String> getDetailTipsList() {
        return DetailTipsList;
    }

    public void setDetailTipsList(ArrayList<String> detailTipsList) {
        DetailTipsList = detailTipsList;
    }
}

package com.traversebd.calorie_hunter.models.healthtips;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class HealthTips implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Title;
    private String CollectionDate;
    private String ShortDescription;
    private String Description;
    private String DetailsTips;

    public HealthTips() {
    }

    public HealthTips(String title, String collectionDate, String shortDescription, String description, String detailsTips) {
        Title = title;
        CollectionDate = collectionDate;
        ShortDescription = shortDescription;
        Description = description;
        DetailsTips = detailsTips;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCollectionDate() {
        return CollectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        CollectionDate = collectionDate;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDetailsTips() {
        return DetailsTips;
    }

    public void setDetailsTips(String detailsTips) {
        DetailsTips = detailsTips;
    }
}

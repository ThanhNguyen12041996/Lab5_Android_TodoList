package com.example.minhthanh.lab5_android;

/**
 * Created by minh thanh on 4/5/2018.
 */

public class ViewDetail
{
    String date;
    String name;
    String level;

    public ViewDetail(String date, String name, String level) {
        this.date = date;
        this.name = name;
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

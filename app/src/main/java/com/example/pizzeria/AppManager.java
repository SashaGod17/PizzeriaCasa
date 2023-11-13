package com.example.pizzeria;

import android.app.Activity;

import java.util.ArrayList;

public class AppManager {
    private static AppManager instance;
    private ArrayList<Activity> activities;

    private AppManager() {
        activities = new ArrayList<>();
    }

    public static synchronized AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
}

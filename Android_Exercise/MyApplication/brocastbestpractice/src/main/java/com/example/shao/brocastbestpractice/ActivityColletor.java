package com.example.shao.brocastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shao on 2016/7/29.
 */
public class ActivityColletor {
    private static List<Activity> activityList = new ArrayList<>();
    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }
    public static void finishAll() {
        for(int i = 0 ; i < activityList.size(); i ++) {
            Activity activity = activityList.get(i);
            if(! activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}

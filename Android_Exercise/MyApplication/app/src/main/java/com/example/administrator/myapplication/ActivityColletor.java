package com.example.administrator.myapplication;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shao on 2016/7/21.
 */
public class ActivityColletor {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public  static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAllActivities() {
        for(int i = 0; i < activities.size(); i ++) {
            Activity activity = activities.get(i);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}

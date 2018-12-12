package com.harpaleapps.taskautomator;

import android.app.Application;

public class TaskAutomatorApplication extends Application {
    private static TaskAutomatorApplication sApplication;

    public static TaskAutomatorApplication getAppContext() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

}

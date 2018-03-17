package com.rajesh.smarttaskmanager;

import android.app.Application;

/**
 * Created by user on 30-01-2018.
 */


import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import timber.log.Timber;

import static timber.log.Timber.DebugTree;

public class SmartApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

     //   if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
//        } else {
//            Timber.plant(new CrashReportingTree());
//        }
    }

//    /**
//     * A tree which logs important information for crash reporting.
//     */
//    private static class CrashReportingTree extends Timber.Tree {
//        @Override
//        protected void log(int priority, String tag, @NonNull String message, Throwable t) {
//            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
//                return;
//            }
//
//            FakeCrashLibrary.log(priority, tag, message);
//
//            if (t != null) {
//                if (priority == Log.ERROR) {
//                    FakeCrashLibrary.logError(t);
//                } else if (priority == Log.WARN) {
//                    FakeCrashLibrary.logWarning(t);
//                }
//            }
//        }
//    }

}

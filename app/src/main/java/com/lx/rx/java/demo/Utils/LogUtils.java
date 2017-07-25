package com.lx.rx.java.demo.Utils;

import android.util.Log;

import java.util.Date;

public class LogUtils {
    private static final String TAG = "RxJava";

    public static boolean LogEnable = true;

    public static void v(String string) {
        if (LogEnable) {
            Log.v(TAG, string);
        }
    }

    public static void d(String string) {
        if (LogEnable) {
            Log.d(TAG, string);
        }
    }

    public static void e(String string) {
        if (LogEnable) {
            Log.e(TAG, string);
        }
    }

    public static void api(String string) {
        if (LogEnable) {
            Log.d(TAG, string);
        }
    }


    public static void logCurrentTime() {
        LogUtils.d(new Date(System.currentTimeMillis()).toString());
    }
}

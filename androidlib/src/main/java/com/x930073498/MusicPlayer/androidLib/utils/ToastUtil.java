package com.x930073498.MusicPlayer.androidLib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by x930073498 on 17-5-5.
 */

public class ToastUtil {

    private static Toast toast;

    public static void show(Context context, String msg, int duration) {
        if (toast == null) toast = Toast.makeText(context.getApplicationContext(), msg, duration);
        else {
            toast.setDuration(duration);
            toast.setText(msg);
        }
        toast.show();
    }

    public static void show(Context context, int resId, int duration) {
        if (toast == null) toast = Toast.makeText(context.getApplicationContext(), resId, duration);
        else {
            toast.setDuration(duration);
            toast.setText(resId);
        }
        toast.show();
    }
}

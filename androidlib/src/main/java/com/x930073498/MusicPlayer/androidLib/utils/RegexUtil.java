package com.x930073498.MusicPlayer.androidLib.utils;


import android.util.Patterns;

import java.util.regex.Matcher;

/**
 * Created by x930073498 on 17-5-9.
 */

public class RegexUtil {
    private RegexUtil() {
        throw new RuntimeException("工具类不能实例化");
    }

    public static boolean isNetUrl(CharSequence target) {
        Matcher matcher = Patterns.WEB_URL.matcher(target);
        return matcher.matches();
    }

    public static boolean isPhoneNumber(CharSequence target) {
        Matcher matcher = Patterns.PHONE.matcher(target);
        return matcher.matches();
    }

    public static boolean isEmail(CharSequence target) {
        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(target);
        return matcher.matches();
    }

}

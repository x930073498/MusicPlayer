package com.x930073498.androidLib.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Created by x930073498 on 17-5-5.
 */

public class FileCacheUtil {
    public static boolean save(Context context, String path, Serializable object) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            int result = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
            if (result != PackageManager.PERMISSION_GRANTED) {
                ToastUtil.show(context, "已经拒绝访问文件，无法打开文件，请重新授权", Toast.LENGTH_SHORT);
                return false;
            }
        }
        if (TextUtils.isEmpty(path)) return false;
        File file = new File(path);
        File parent;
        boolean flag = true;
        if ((parent = file.getParentFile()) != null && !parent.exists()) {
            try {
                flag = parent.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (!flag) return false;
        if (!file.exists()) {
            try {
                flag = file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (!flag) return false;

        ObjectOutputStream stream;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(object);
            stream.flush();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T load(Context context, String path) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            int result = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
            if (result != PackageManager.PERMISSION_GRANTED) {
                ToastUtil.show(context, "已经拒绝访问文件，无法打开文件，请重新授权", Toast.LENGTH_SHORT);
                return null;
            }
        }
        if (TextUtils.isEmpty(path)) return null;
        File file = new File(path);
        if (!file.exists()) return null;
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(file));
            Object result = stream.readObject();
            return (T) result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (stream != null) stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

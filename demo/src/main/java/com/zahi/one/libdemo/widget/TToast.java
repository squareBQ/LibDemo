package com.zahi.one.libdemo.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zahi.one.libdemo.R;

/**
 * Custom toast
 * Created by zahi on 2019-06-17.
 */
public class TToast {

    public static void show(Context context, String msg) {
        show(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showLong(Context context, String msg) {
        show(context, msg, Toast.LENGTH_LONG);
    }

    private static void show(Context context, String message, int show_length) {
        View toastView = LayoutInflater.from(context)
                .inflate(R.layout.toast_custom_layout, null);
        TextView msgTv = toastView.findViewById(R.id.toast_tv);
        msgTv.setText(message);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(show_length);
        toast.setView(toastView);
        toast.show();
    }
}

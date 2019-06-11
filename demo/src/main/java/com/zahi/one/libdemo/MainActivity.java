package com.zahi.one.libdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.widget.TextView;

import com.zahi.lib.zahilib.utils.HanziToPinyin;
import com.zahi.lib.zahilib.widget.DrawableBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        Drawable drawable = new DrawableBuilder(this)
                .line(1, 0xffff0000)
                .dashWidth(5f).dashGap(1f)
                .corner(0)
                .build();
        tv.setBackground(drawable);

        SparseArray<String> array = new SparseArray<>(2);
        String arr0 = array.get(0);
        Log.e("MainActivity", "0 is: " + arr0 + ", 1 is: " + array.get(1));
        arr0 = "Zero";
        array.put(1, "One");
        Log.e("MainActivity", "0 is: " + array.get(0) + ", 1 is: " + array.get(1));

        ArrayList<HanziToPinyin.Token> tokens = HanziToPinyin.getInstance().get("生活大爆炸");
        for (HanziToPinyin.Token token : tokens) {
            Log.d("MainActivity", token.target.toLowerCase());
        }
    }
}

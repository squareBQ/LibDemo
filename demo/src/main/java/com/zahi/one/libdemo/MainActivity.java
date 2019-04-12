package com.zahi.one.libdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zahi.lib.zahilib.widget.DrawableBuilder;

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
    }
}

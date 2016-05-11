package com.zyp.sweat_money;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hitherejoe.mvvm_hackernews.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    public static final String ACTION_RESTART = "com.zyp.sweat_money.restart";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}

package com.example.android.igmarketapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        MarketRecordFragmentAdapter categoryAdapter = new MarketRecordFragmentAdapter(this, getSupportFragmentManager());
        pager.setAdapter(categoryAdapter);
        tabLayout.setupWithViewPager(pager);
    }
}

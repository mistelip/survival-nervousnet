package com.example.irene.survival_v3.tipsActivities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.irene.survival_v3.R;


public class TornadoTipsActivity extends AppCompatActivity {

    TipsPagerAdapter mPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tornado_tips);

        mViewPager = (ViewPager) findViewById(R.id.tipsViewPager);
        mPagerAdapter = new TipsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }
}

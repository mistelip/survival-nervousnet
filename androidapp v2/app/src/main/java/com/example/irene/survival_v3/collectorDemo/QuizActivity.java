package com.example.irene.survival_v3.collectorDemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;


import com.example.irene.survival_v3.R;

public class QuizActivity extends FragmentActivity {
    // When requested, this adapter returns a PageFragment,
    // representing an object in the collection.

    //SwipeAdapter swipeAdapter;
    CustomPagerAdapter mCustomPagerAdapter;
    CustomViewPager mViewPager;
    private final QuizController quizController =  new QuizController();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //final ActionBar actionBar = getActionBar();

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Log.d("#ColectionActivity","Loaded quiz activity");
        mViewPager = (CustomViewPager) findViewById(R.id.myViewPager);
        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), quizController, mViewPager, this);
        mViewPager.setAdapter(mCustomPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CustomFragmentInterface fragment = (CustomFragmentInterface) mCustomPagerAdapter.instantiateItem(mViewPager, position);
                if (fragment != null) {
                    fragment.fragmentBecameVisible();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //mViewPager = (CustomViewPager) findViewById(R.id.myViewPager);
        //swipeAdapter = new SwipeAdapter(getSupportFragmentManager(), quizController, mViewPager);
        //mViewPager.setAdapter(swipeAdapter);

        mViewPager.setPagingEnabled(true);

    }


}





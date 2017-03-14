package com.example.irene.survival_v3.collectorDemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Irene on 06/02/2017.
 */

public class CustomPagerAdapter extends FragmentPagerAdapter {
    private final QuizController quizController;
    protected Context mContext;
    private CustomViewPager viewPager;

    public CustomPagerAdapter(FragmentManager fm, QuizController quizController, CustomViewPager pager, Context context) {
        super(fm);
        this.quizController = quizController;
        this.viewPager = pager;
        mContext = context;

    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            Log.d("#SwipeAdapter", "FIRST Fragment");
            PageFragment0 fragment = new PageFragment0();
            fragment.setViewPager(viewPager);
            return fragment;
        }else {
            Log.d("#SwipeAdapter", "next Fragment");
            PageFragment fragment = new PageFragment();
            fragment.setQuizController(quizController);
            fragment.setViewPager(viewPager);
            return fragment;
        }

        /*Log.d("#SwipeAdapter", "next Fragment loaded");
        PageFragment fragment = new PageFragment();
        fragment.setQuizController(quizController);
        fragment.setViewPager(viewPager);
        return fragment;*/
    }


    @Override
    public int getCount() {

        //Log.d("#SwipeAdapter", "Num QUEST: " + quizController.MAX_NUM_QUEST);
        return quizController.MAX_NUM_QUEST;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return "QUESTION " + (i + 1);
    }
}

package com.example.irene.survival_v3.collectorDemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Irene on 06/02/2017.
 */

public class CustomPagerAdapter extends FragmentPagerAdapter {
    private final QuizController quizController;
    protected Context mContext;
    private int numMaxPages;
    private CustomViewPager viewPager;

    public CustomPagerAdapter(FragmentManager fm, QuizController quizController, CustomViewPager pager, Context context) {
        super(fm);
        this.quizController = quizController;
        this.viewPager = pager;
        mContext = context;
        this.numMaxPages = quizController.MAX_NUM_QUEST;
        Log.d("#SwipeAdapter", "Loaded Swipe Adapter");
    }


    @Override
    public PageFragment getItem(int position) {
        Log.d("#SwipeAdapter", "next Fragment");
        // TODO: add multiple possible pageFragment views (in case of not checkbox)
        PageFragment fragment = new PageFragment();
        fragment.setQuizController(quizController);
        fragment.setViewPager(viewPager);
        return fragment;
    }


    @Override
    public int getCount() {
        return numMaxPages;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return "QUESTION " + (i + 1);
    }
}

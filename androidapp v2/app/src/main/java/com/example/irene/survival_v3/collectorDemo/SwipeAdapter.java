package com.example.irene.survival_v3.collectorDemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by Irene on 06/02/2017.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {
    private final QuizController quizController;
    private CustomViewPager viewPager;
    private int numMaxPages;

    public SwipeAdapter(FragmentManager fm, QuizController quiz, CustomViewPager pager) {
        super(fm);
        this.quizController = quiz;
        this.viewPager = pager;
        this.numMaxPages = quizController.MAX_NUM_QUEST;
        Log.d("#SwipeAdapter","Loaded Swipe Adapter");
    }

    @Override
    public PageFragment getItem(int i) {
        Log.d("#SwipeAdapter","next Fragment");
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
        return "QUESTION " + (i+1) ;
    }
}

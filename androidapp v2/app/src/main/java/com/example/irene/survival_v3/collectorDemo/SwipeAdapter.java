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

    public SwipeAdapter(FragmentManager fm, QuizController quiz, CustomViewPager pager) {
        super(fm);
        this.quizController = quiz;
        this.viewPager = pager;
        Log.d("#SwipeAdapter","Loaded Swipe Adapter");
    }

    @Override
    public PageFragment getItem(int i) {
        Log.d("#SwipeAdapter","next Fragment");
        PageFragment fragment = new PageFragment();
        fragment.setQuizController(quizController);
        fragment.setViewPager(viewPager);
        //Bundle args = new Bundle();
        //args.putInt("count",i);
        //args.putInt(ObjectFragment.ARG_OBJECT, i + 1);
        //fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return "QUESTION " + (i+1) ;
    }
}

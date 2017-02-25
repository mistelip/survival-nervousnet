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

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
        Log.d("#SwipeAdapter","Loaded Swipe Adapter");
        quizController = new QuizController();
    }

    @Override
    public PageFragment getItem(int i) {
        PageFragment fragment = new PageFragment();
        fragment.setQuizController(quizController);
        Bundle args = new Bundle();
        args.putInt("count", 1 + i);
        //args.putInt(ObjectFragment.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return "QUESTION " + (i + 1);
    }
}

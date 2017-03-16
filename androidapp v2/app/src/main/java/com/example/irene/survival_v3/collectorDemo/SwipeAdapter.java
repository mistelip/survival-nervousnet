package com.example.irene.survival_v3.collectorDemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by Irene on 06/02/2017.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {
    private final QuizController quizController;
    private QuizViewPager viewPager;
    private int numMaxPages;

    public SwipeAdapter(FragmentManager fm, QuizController quiz, QuizViewPager pager) {
        super(fm);
        this.quizController = quiz;
        this.viewPager = pager;
        this.numMaxPages = quizController.MAX_NUM_QUEST;
        Log.d("#SwipeAdapter","Loaded Swipe Adapter");
    }

    @Override
    public QuizPageFragment getItem(int i) {
        Log.d("#SwipeAdapter","next Fragment");
        QuizPageFragment fragment = new QuizPageFragment();
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

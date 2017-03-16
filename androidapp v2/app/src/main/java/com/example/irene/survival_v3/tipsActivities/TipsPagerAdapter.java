package com.example.irene.survival_v3.tipsActivities;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.irene.survival_v3.collectorDemo.QuizPageFragment;
import com.example.irene.survival_v3.collectorDemo.QuizViewPager;
import com.example.irene.survival_v3.collectorDemo.QuizPageFragmentInitial;
import com.example.irene.survival_v3.collectorDemo.QuizController;

/**
 * Created by Irene on 06/02/2017.
 */

public class TipsPagerAdapter extends FragmentPagerAdapter {
    private final QuizController quizController;
    protected Context mContext;
    private QuizViewPager viewPager;

    public TipsPagerAdapter(FragmentManager fm, QuizController quizController, QuizViewPager pager, Context context) {
        super(fm);
        this.quizController = quizController;
        this.viewPager = pager;
        mContext = context;

    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            Log.d("#SwipeAdapter", "FIRST Fragment");
            QuizPageFragmentInitial fragment = new QuizPageFragmentInitial();
            fragment.setViewPager(viewPager);
            return fragment;
        }else {
            Log.d("#SwipeAdapter", "next Fragment");
            QuizPageFragment fragment = new QuizPageFragment();
            fragment.setQuizController(quizController);
            fragment.setViewPager(viewPager);
            return fragment;
        }

        /*Log.d("#SwipeAdapter", "next Fragment loaded");
        QuizPageFragment fragment = new QuizPageFragment();
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

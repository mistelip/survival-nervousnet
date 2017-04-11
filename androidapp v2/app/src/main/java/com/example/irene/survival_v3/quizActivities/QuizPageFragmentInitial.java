package com.example.irene.survival_v3.quizActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.irene.survival_v3.R;

/**
 * Created by Irene on 07/03/2017.
 */

public class QuizPageFragmentInitial extends Fragment implements QuizFragmentInterface {

    private QuizViewPager viewPager;
    private View myView;

    public QuizPageFragmentInitial() {}

    public void setViewPager(QuizViewPager vp) {
        viewPager = vp;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment0_page, container, false);
        myView = view;
        return view;
    }

    @Override
    public void fragmentBecameVisible() {
        viewPager.setAllowedSwipeDirection(SwipeDirection.all);
        /*
        if(viewPager.lastSwipeLeft){
            Log.d("#View Pager", "Detected swipe LEFT");
        }else{
            Log.d("#View Pager", "Detected swipe RIGHT");
        }*/
        ImageView swipeImg = (ImageView) myView.findViewById(R.id.imageSwipe);
        swipeImg.setImageResource(R.drawable.swipe);
    }
}

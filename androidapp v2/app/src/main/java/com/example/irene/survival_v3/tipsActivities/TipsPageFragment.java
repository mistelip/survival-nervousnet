package com.example.irene.survival_v3.tipsActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.irene.survival_v3.R;
import com.example.irene.survival_v3.quizActivities.QuizPageFragment;
import com.example.irene.survival_v3.quizActivities.QuizViewPager;

/**
 * Created by Irene on 16/03/2017.
 */

public class TipsPageFragment extends Fragment {

    public TipsPageFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tips_fragment_page, container, false);
        //TODO: set texts for before during and after tips
        TextView text = (TextView) view.findViewById(R.id.tipsTextView);
        text.setText("Page " + getArguments().getInt("pos"));
        return view;
    }
}

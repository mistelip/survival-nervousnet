package com.example.irene.survival_v3.collectorDemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.irene.survival_v3.R;

import java.util.ArrayList;

/**
 * Created by Irene on 07/03/2017.
 */

public class PageFragment0 extends Fragment {

    private CustomViewPager viewPager;

    public PageFragment0() {}

    public void setViewPager(CustomViewPager vp) {
        viewPager = vp;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment0_page, container, false);
        viewPager.setPagingEnabled(true);
        ImageView swipeImg = (ImageView) view.findViewById(R.id.imageSwipe);
        swipeImg.setImageResource(R.drawable.swipe);
        return view;
    }
}

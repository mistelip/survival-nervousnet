package com.example.irene.survival_v3.tipsActivities;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by Irene on 06/02/2017.
 */

public class TipsPagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "BEFORE", "DURING", "AFTER" };

    public TipsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TipsPageFragment fragment = new TipsPageFragment();

        Bundle args = new Bundle();
        args.putInt("pos", position);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return tabTitles[i];
    }
}

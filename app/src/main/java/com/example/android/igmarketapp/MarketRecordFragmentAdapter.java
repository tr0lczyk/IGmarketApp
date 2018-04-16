package com.example.android.igmarketapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MarketRecordFragmentAdapter extends FragmentPagerAdapter {

    private Context pagerContext;

    private int fragmentNumber = 3;

    public MarketRecordFragmentAdapter (Context context, FragmentManager fm){
        super(fm);
        pagerContext = context;
    }

    public static int positionCurrent;

    public static int getPositionCurrent(){
        return positionCurrent;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            positionCurrent = position;
            return new UkFragment();
        } else if (position == 1) {
            positionCurrent = position;
            return new DeFragment();
        } else {
            positionCurrent = position;
            return new FrFragment();
        }
    }

    @Override
    public int getCount() {
        return fragmentNumber;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return pagerContext.getString(R.string.uk);
        } else if (position == 1) {
            return pagerContext.getString(R.string.germany);
        } else {
            return pagerContext.getString(R.string.france);
        }
    }

}

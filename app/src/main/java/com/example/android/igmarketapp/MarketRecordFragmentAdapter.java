package com.example.android.igmarketapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MarketRecordFragmentAdapter extends FragmentPagerAdapter {

    private Context pagerContext;

    public MarketRecordFragmentAdapter (Context context, FragmentManager fm){
        super(fm);
        pagerContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new UkFragment();
        } else if (position == 1) {
            return new DeFragment();
        } else {
            return new FrFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
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

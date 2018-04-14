package com.example.android.igmarketapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MarketRecordFragmentAdapter extends FragmentPagerAdapter {

    /**
     * Create a new adapter object.
     *
     * @parametr context is the context of the app
     * @parametr fm - fragment manager that keeps each fragment's state in the adapter
     *           across swipes.
     */

    private Context pagerContext;

    public MarketRecordFragmentAdapter (Context context, FragmentManager fm){
        super(fm);
        pagerContext = context;
    }

    /**
     *
     * @parametr position the position of the tab
     * @return returns fragment corresponding to the position
     */

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

    /**
     * Return the total number of pages.
     */

    @Override
    public int getCount() {
        return 3;
    }
    /**
     *
     * @parametr position the position of the tab
     * @return returns tab's name of the fragment corresponding to the position
     */

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

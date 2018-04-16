package com.example.android.igmarketapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MarketRecordFragmentAdapter extends FragmentPagerAdapter {

    private Context pagerContext;

    private int fragmentCount = 3;

    public MarketRecordFragmentAdapter (Context context, FragmentManager fm){
        super(fm);
        pagerContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new LanguageFragment();
        if (position == 0){
            fragment.setArguments(buildBundle(pagerContext.getString(R.string.ukLink), 1));
        } else if (position == 1) {
            fragment.setArguments(buildBundle(pagerContext.getString(R.string.deLink), 2));
        } else {
            fragment.setArguments(buildBundle(pagerContext.getString(R.string.frLink), 3));
        }
        return fragment;
    }

    private Bundle buildBundle(String urlLink, int loaderId) {
        Bundle bundle = new Bundle();
        bundle.putString("urlLink", urlLink);
        bundle.putInt("loaderId", loaderId);
        return bundle;
    }

    @Override
    public int getCount() {
        return fragmentCount;
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

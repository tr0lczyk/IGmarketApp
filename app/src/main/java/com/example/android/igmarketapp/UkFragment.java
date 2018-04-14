package com.example.android.igmarketapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class UkFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<MarketRecord>> {

    public UkFragment() {
    }

    private static final int MARKETRECORD_LOADER_ID = 1;

    public static final String LOG_TAG = UkFragment.class.getName();

    public static final String UK_URL_LINK = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/en_GB/igi";

    private MarketRecordAdapter newAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        android.support.v4.app.LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(MARKETRECORD_LOADER_ID, null, this);

        ListView listView = rootView.findViewById(R.id.list_view);
        newAdapter = new MarketRecordAdapter(getActivity(),new ArrayList<MarketRecord>());
        listView.setAdapter(newAdapter);
        return rootView;
    }

    @Override
    public Loader<List<MarketRecord>> onCreateLoader(int id,  Bundle args) {
        Log.e(LOG_TAG, "Loader created");
        return new MarketRecordsLoader(getActivity(), UK_URL_LINK);
    }

    @Override
    public void onLoadFinished(Loader<List<MarketRecord>> loader, List<MarketRecord> data) {
        newAdapter.clear();
        newAdapter.addAll(data);
    }

    @Override
    public void onLoaderReset(Loader<List<MarketRecord>> loader) {
        Log.e(LOG_TAG, "Loader reset");
        newAdapter.clear();
    }
}

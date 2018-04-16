package com.example.android.igmarketapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class DeFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<MarketRecord>> {

    public DeFragment() {
    }

    private static final int MARKETRECORD_LOADER_ID = 2;

    public static final String DE_URL_LINK = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/de_DE/dem";

    private MarketRecordAdapter newAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        ListView listView = rootView.findViewById(R.id.list_view);
        newAdapter = new MarketRecordAdapter(getActivity(), new ArrayList<MarketRecord>());
        listView.setAdapter(newAdapter);

        ConnectivityManager connectionPossible = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionPossible.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            android.support.v4.app.LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(MARKETRECORD_LOADER_ID, null, this);
        } else {
            Toast toast = Toast.makeText(getActivity(),R.string.no_connect,Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        return rootView;
    }

    @Override
    public Loader<List<MarketRecord>> onCreateLoader(int id,  Bundle args) {
        return new MarketRecordsLoader(getActivity(), DE_URL_LINK);
    }

    @Override
    public void onLoadFinished(Loader<List<MarketRecord>> loader, List<MarketRecord> data) {
        newAdapter.clear();
        newAdapter.addAll(data);
    }

    @Override
    public void onLoaderReset(Loader<List<MarketRecord>> loader) {
        newAdapter.clear();
    }
}

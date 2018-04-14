package com.example.android.igmarketapp;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import java.util.List;

public class MarketRecordsLoader extends android.support.v4.content.AsyncTaskLoader<List<MarketRecord>> {

    private static final String LOG_TAG = MarketRecordsLoader.class.getName();

    private String marketRecordUrl;


    public MarketRecordsLoader(Context context, String url){
        super(context);
        marketRecordUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG, "Loader started");
        forceLoad();
    }

    @Override
    public List<MarketRecord> loadInBackground() {
        Log.e(LOG_TAG, "Loader inBackground");
        if(marketRecordUrl == null){
            return null;
        }
        Log.e(LOG_TAG, "Loader fetching");
        List<MarketRecord> marketRecords = QueryUtils.fetchMarketRecordData(marketRecordUrl);
        return marketRecords;
    }
}

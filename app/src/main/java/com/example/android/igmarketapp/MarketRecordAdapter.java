package com.example.android.igmarketapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MarketRecordAdapter extends ArrayAdapter<MarketRecord> {

    public MarketRecordAdapter(Activity context, ArrayList<MarketRecord> marketRecords) {
        super(context, 0, marketRecords);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            MarketRecord currentMarketRecord = getItem(position);

            TextView instrumentName = listItemView.findViewById(R.id.instrumentName);
            instrumentName.setText(currentMarketRecord.getPresentedInstrumentName());

            TextView instrumentBid = listItemView.findViewById(R.id.bidView);
            instrumentBid.setText(currentMarketRecord.getPresentedBid());

            TextView instrumentOffer = listItemView.findViewById(R.id.offerView);
            instrumentOffer.setText(currentMarketRecord.getPresentedOffer());

        }
        return listItemView;
    }
}

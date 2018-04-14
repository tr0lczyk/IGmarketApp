package com.example.android.igmarketapp;

import android.support.annotation.NonNull;

public class MarketRecord implements Comparable<MarketRecord> {

    private String presentedInstrumentName;

    private String presentedBid;

    private String presentedOffer;

    public MarketRecord(String newPresentedInstrumentName, String newPresentedBid, String newPresentedOffer){
        presentedInstrumentName = newPresentedInstrumentName;
        presentedBid = newPresentedBid;
        presentedOffer = newPresentedOffer;
    }

    public String getPresentedBid() {
        return presentedBid;
    }

    public String getPresentedInstrumentName(){
        return presentedInstrumentName;
    }

    public String getPresentedOffer() {
        return presentedOffer;
    }

    @Override
    public int compareTo( MarketRecord marketRecord) {
        int comparedNames = presentedInstrumentName.compareTo(marketRecord.presentedInstrumentName);
        return comparedNames;
    }
}

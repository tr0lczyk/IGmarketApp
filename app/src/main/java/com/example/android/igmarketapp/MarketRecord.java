package com.example.android.igmarketapp;

public class MarketRecord {

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
}

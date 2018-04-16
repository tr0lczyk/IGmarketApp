package com.example.android.igmarketapp;

public class MarketRecord implements Comparable<MarketRecord> {

    private String presentedInstrumentName;

    private String presentedBid;

    private String presentedOffer;

    public MarketRecord(String PresentedInstrumentName, String PresentedBid, String PresentedOffer){
        this.presentedInstrumentName = PresentedInstrumentName;
        this.presentedBid = PresentedBid;
        this.presentedOffer = PresentedOffer;
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
        return presentedInstrumentName.compareTo(marketRecord.presentedInstrumentName);
    }
}

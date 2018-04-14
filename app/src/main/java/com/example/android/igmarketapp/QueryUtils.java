package com.example.android.igmarketapp;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.example.android.igmarketapp.MainActivity.LOG_TAG;


public final class QueryUtils {

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL", e);
        }
        return url;
    }


    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return null;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the marketRecords JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        try {
            if(inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                while(line != null){
                    output.append(line);
                    line = bufferedReader.readLine();
                }
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        return output.toString();
    }

    private static final List<MarketRecord> extractFeatureFromJson(String marketRecordJson) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(marketRecordJson)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding marketRecords to
        List<MarketRecord> marketRecords = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(marketRecordJson);

            JSONArray marketRecordArray = baseJsonResponse.getJSONArray("markets");

            for (int i = 0; i < baseJsonResponse.length(); i++) {


                JSONObject currentMarketRecord = marketRecordArray.getJSONObject(i);

                String instrumentName = currentMarketRecord.getString("instrumentName");

                String instrumentBid = currentMarketRecord.getString("displayBid");

                String instrumentOffer = currentMarketRecord.getString("displayOffer");

               MarketRecord newMarketRecord = new MarketRecord(instrumentName,instrumentBid, instrumentOffer);

               marketRecords.add(newMarketRecord);
            }


        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the marketRecord JSON results", e);
        }

        // Return the list of marketRecords
        return marketRecords;
    }

    public static List<MarketRecord> fetchMarketRecordData(String requestUrl) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link MarketRecord}s
        List<MarketRecord> marketRecords = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link MarketRecord}s
        return marketRecords;
    }

    private QueryUtils() {
    }
}

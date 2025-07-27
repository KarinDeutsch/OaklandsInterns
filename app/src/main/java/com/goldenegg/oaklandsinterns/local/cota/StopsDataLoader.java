package com.goldenegg.oaklandsinterns.local.cota;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StopsDataLoader {

    public static List<Stop> loadStops(Context context) {
        List<Stop> stops = new ArrayList<>();
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open("stops.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // Skip the header line
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 5) {
                    String stopId = parts[0];
                    String stopName = parts[2];
                    double latitude = Double.parseDouble(parts[4]);
                    double longitude = Double.parseDouble(parts[5]);
                    stops.add(new Stop(stopId, stopName, latitude, longitude));
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stops;
    }
}
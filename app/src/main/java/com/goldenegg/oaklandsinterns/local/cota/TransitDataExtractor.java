package com.goldenegg.oaklandsinterns.local.cota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransitDataExtractor {

    public static void main(String[] args) {
        String stopsFile = "stops.txt";
        String routesFile = "routes.txt";
        String tripsFile = "trips.txt";
        String stopTimesFile = "stop_times.txt";

        Map<String, String> stops = readStops(stopsFile);
        Map<String, String> routes = readRoutes(routesFile);
        Map<String, String> trips = readTrips(tripsFile);
        Map<String, List<String>> tripSchedules = readTripSchedules(stopTimesFile);

        System.out.println("Stops: " + stops);
        System.out.println("Routes: " + routes);
        System.out.println("Trips: " + trips);
        System.out.println("Trip Schedules: " + tripSchedules);
    }

    public static Map<String, String> readStops(String file) {
        Map<String, String> stops = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                stops.put(values[0], values[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stops;
    }

    public static Map<String, String> readRoutes(String file) {
        Map<String, String> routes = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                routes.put(values[0], values[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public static Map<String, String> readTrips(String file) {
        Map<String, String> trips = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                trips.put(values[2], values[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trips;
    }

    public static Map<String, List<String>> readTripSchedules(String file) {
        Map<String, List<String>> tripSchedules = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String tripId = values[0];
                String arrivalTime = values[1];

                if (!tripSchedules.containsKey(tripId)) {
                    tripSchedules.put(tripId, new ArrayList<>());
                }
                tripSchedules.get(tripId).add(arrivalTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tripSchedules;
    }
}
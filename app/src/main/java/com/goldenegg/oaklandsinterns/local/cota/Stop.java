package com.goldenegg.oaklandsinterns.local.cota;

public class Stop {
    private String stopId;
    private String stopName;
    private double stopLatitude;
    private double stopLongitude;

    public Stop(String stopId, String stopName, double stopLatitude, double stopLongitude) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.stopLatitude = stopLatitude;
        this.stopLongitude = stopLongitude;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public double getStopLatitude() {
        return stopLatitude;
    }

    public void setStopLatitude(double stopLatitude) {
        this.stopLatitude = stopLatitude;
    }

    public double getStopLongitude() {
        return stopLongitude;
    }

    public void setStopLongitude(double stopLongitude) {
        this.stopLongitude = stopLongitude;
    }

    @Override
    public String toString() {
        return stopId + ": " + stopName + " (" + stopLatitude + ", " + stopLongitude + ")";
    }
}
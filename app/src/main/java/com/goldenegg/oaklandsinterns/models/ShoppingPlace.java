package com.goldenegg.oaklandsinterns.models;

public class ShoppingPlace {
    private final String name;
    private final String address;
    private final String phone;
    private final String website;
    private final String category;
    private final double lat;
    private final double lon;

    public ShoppingPlace(String name, String address, String phone, String website, String category, double lat, double lon) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.category = category;
        this.lat = lat;
        this.lon = lon;
    }

    public double getDistanceInMeters(double baseLat, double baseLon) {
        double earthRadius = 6371; // radius of the Earth in kilometers
        double dLat = Math.toRadians(lat - baseLat);
        double dLon = Math.toRadians(lon - baseLon);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(baseLat)) * Math.cos(Math.toRadians(lat)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c * 1000; // return distance in meters
    }

    // Getter methods for name, address, etc.
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getWebsite() { return website; }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

}
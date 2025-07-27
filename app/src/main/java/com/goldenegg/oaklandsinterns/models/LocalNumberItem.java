package com.goldenegg.oaklandsinterns.models;

public class LocalNumberItem {
    private final int iconRes;
    private final String type;
    private final String name;
    private final String address;
    private final String phone;
    private final String city;

    public LocalNumberItem(String type, String name, String address, String phone, int iconRes, String city) {
        this.type = type;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.iconRes = iconRes;
        this.city = city;
    }


    public int getIconRes() { return iconRes; }
    public String getType() { return type; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
}
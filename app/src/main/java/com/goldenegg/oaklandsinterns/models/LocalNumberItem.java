package com.goldenegg.oaklandsinterns.models;

public class LocalNumberItem {
    private int iconRes;
    private String type;
    private String name;
    private String address;
    private String phone;
    private String city;

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
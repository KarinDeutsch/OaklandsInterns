package com.goldenegg.oaklandsinterns.plant_knowledge;

import android.os.Parcel;
import android.os.Parcelable;

public class PlantCategory implements Parcelable { // Implement Parcelable
    private int imageResourceId;
    private String title;
    private String shortDescription;
    private String longDescription; // New: Detailed description for the detail screen
    private String careTips;        // New: Specific care tips for this category
    private String OhioContext;     // New: How this relates to Ohio's climate/uses

    public PlantCategory(int imageResourceId, String title, String shortDescription,
                         String longDescription, String careTips, String OhioContext) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.careTips = careTips;
        this.OhioContext = OhioContext;
    }

    // --- Getters ---
    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getCareTips() {
        return careTips;
    }

    public String getOhioContext() {
        return OhioContext;
    }

    // --- Parcelable Implementation ---

    protected PlantCategory(Parcel in) {
        imageResourceId = in.readInt();
        title = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        careTips = in.readString();
        OhioContext = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResourceId);
        dest.writeString(title);
        dest.writeString(shortDescription);
        dest.writeString(longDescription);
        dest.writeString(careTips);
        dest.writeString(OhioContext);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlantCategory> CREATOR = new Creator<PlantCategory>() {
        @Override
        public PlantCategory createFromParcel(Parcel in) {
            return new PlantCategory(in);
        }

        @Override
        public PlantCategory[] newArray(int size) {
            return new PlantCategory[size];
        }
    };
}
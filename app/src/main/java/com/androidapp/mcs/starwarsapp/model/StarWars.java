package com.androidapp.mcs.starwarsapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StarWars implements Parcelable {



    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("mass")
    @Expose
    private String mass;

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("results")
    @Expose
    private List<StarWars> results = null;



    public List<StarWars> getResults() {
        return results;
    }

    public void setResults(List<StarWars> results) {
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "StarWars{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", created='" + created + '\'' +
                ", results=" + results +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.height);
        dest.writeString(this.mass);
        dest.writeString(this.created);
        dest.writeList(this.results);
    }

    public StarWars() {
    }

    protected StarWars(Parcel in) {
        this.name = in.readString();
        this.height = in.readString();
        this.mass = in.readString();
        this.created = in.readString();
        this.results = new ArrayList<StarWars>();
        in.readList(this.results, StarWars.class.getClassLoader());
    }

    public static final Parcelable.Creator<StarWars> CREATOR = new Parcelable.Creator<StarWars>() {
        @Override
        public StarWars createFromParcel(Parcel source) {
            return new StarWars(source);
        }

        @Override
        public StarWars[] newArray(int size) {
            return new StarWars[size];
        }
    };
}

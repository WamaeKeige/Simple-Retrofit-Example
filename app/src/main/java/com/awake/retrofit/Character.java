package com.awake.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Character  {
    @SerializedName("results")

    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("species")
    private String species;
    @SerializedName("status")
    private String status;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecies() {
        return species;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character(int id, String name, String status, String species, String gender) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.gender = gender;
        this.species = species;
    }
}


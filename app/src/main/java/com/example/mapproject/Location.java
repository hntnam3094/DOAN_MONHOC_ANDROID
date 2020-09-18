package com.example.mapproject;

public class Location {
    private int id;

    private String name;

    private String title;

    private double v1;

    private double v2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }

    public Location(int id, String name, String title, double v1, double v2) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.v1 = v1;
        this.v2 = v2;
    }
}

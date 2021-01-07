package com.example.muhammad.backendinitiative.levelone.arraycrudapi.model;

public class Movie {
    private int id;
    private String title;
    private String year;

    protected Movie() {
    }

    public Movie(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public Movie(int id, String t, String yearReleased)
    {
        this.id = id;
        this.title = t;
        this.year = yearReleased;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }
}

package com.example.muhammad.backendinitiative.levelone.arraycrudapi.model;

import java.util.Date;

public class Rentals {
    private int id;
    private int userId;
    private int movieId;
    private Double price;
    private Date rentDate;
    private Date returnDate;

    protected Rentals() {
    }

    public Rentals(int userId, int movieId, Double price, Date rentDate, Date returnDate) {
        this.userId = userId;
        this.movieId = movieId;
        this.price = price;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Rentals(int id, int user, int movie, Double price, Date rentDate, Date returnDate) {
        this.id = id;
        this.userId = user;
        this.movieId = movie;
        this.price = price;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return userId;
    }

    public void setUser(int user) {
        this.userId = user;
    }

    public int getMovie() {
        return movieId;
    }

    public void setMovie(int movie) {
        this.movieId = movie;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

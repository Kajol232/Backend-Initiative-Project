package com.example.muhammad.backendinitiative.levelone.arraycrudapi.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Rentals {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Movie movie;
    @CreationTimestamp
    private LocalDateTime rentDate;
    private Date returnDate;
    private boolean status;

    protected Rentals() {
    }

    public Rentals(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
    }

    public Rentals(User user, Movie movie,  Date returnDate) {
        this.user = user;
        this.movie = movie;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

package com.example.Book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Genre")
//Creating a table with following column
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookno;

    private String img;
    private String title;
    private String author;
    private String theme;
    private double rating;
    private String date;
    private String authimg;
    private String aboutauth;
    private String shortstory;
    private String category; // Change this to lowercase

    // Getters and Setters
    public long getBookno() {
        return bookno;
    }

    public void setBookno(long bookno) {
        this.bookno = bookno;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthimg() {
        return authimg;
    }

    public void setAuthimg(String authimg) {
        this.authimg = authimg;
    }

    public String getAboutauth() {
        return aboutauth;
    }

    public void setAboutauth(String aboutauth) {
        this.aboutauth = aboutauth;
    }

    public String getShortstory() {
        return shortstory;
    }

    public void setShortstory(String shortstory) {
        this.shortstory = shortstory;
    }

    public String getCategory() {
        return category; // Updated getter
    }

    public void setCategory(String category) {
        this.category = category; // Updated setter
    }
}

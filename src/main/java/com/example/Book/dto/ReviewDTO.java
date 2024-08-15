package com.example.Book.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//Creating a table with following column
public class ReviewDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String review;
    private int rating;

    // Constructors, getters, and setters
    public ReviewDTO() {}

    public ReviewDTO(String username, String review, int rating) {
        this.username = username;
        this.review = review;
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

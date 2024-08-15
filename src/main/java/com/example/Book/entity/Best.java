package com.example.Book.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
//Creating a table with following column
@Table(name="Best")
public class Best {
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
    private String review;
    private String username;
    private String userReview;
    @OneToMany(mappedBy = "best", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
    
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserReview() {
		return userReview;
	}
	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}
	public int getUserRating() {
		return userRating;
	}
	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}
	private int userRating;
    public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public long getBookno() {
    	return bookno;
    }
    public void setBookno(long bookno) {
    	this.bookno = bookno;
    }
	public String getShortstory() {
		return shortstory;
	}
	public void setShortstory(String shortstory) {
		this.shortstory = shortstory;
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
    
}

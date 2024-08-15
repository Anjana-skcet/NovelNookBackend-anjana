package com.example.Book.service;

import java.util.List;
import com.example.Book.dto.RecentDTO;
import com.example.Book.dto.ReviewDTO;
import com.example.Book.dto.ReviewrecDTO;

public interface RecentService {

    // Create a recent book
    RecentDTO createRecentBook(RecentDTO recentDTO);

    // Get a recent book by ID
    RecentDTO getRecentBookById(Long bookId);

    // Get all recent books
    List<RecentDTO> getAllRecentBooks();

    // Update a recent book
    RecentDTO updateRecentBook(Long bookId, RecentDTO recentDTO);

    // Delete a recent book
    void deleteRecentBook(Long bookId);

    // Add a review to a book
    void addReview(Long bookId, ReviewrecDTO reviewDTO);

    // Get reviews for a book
    List<ReviewrecDTO> getReviews(Long bookId);
}

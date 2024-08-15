package com.example.Book.service;

import java.util.List;
import com.example.Book.dto.BestDTO;
import com.example.Book.dto.ReviewDTO;

public interface BestService {

    // Create a book
    BestDTO createBook(BestDTO bestDTO);

    // Get a book by ID
    BestDTO getBookById(Long bookId);

    // Get all books
    List<BestDTO> getAllBooks();

    // Update a book
    BestDTO updateBook(Long bookId, BestDTO bestDTO);

    // Delete a book
    void deleteBook(Long bookId);

    // Add a review to a book
    void addReview(Long bookId, ReviewDTO reviewDTO);

    // Get reviews for a book
    List<ReviewDTO> getReviews(Long bookId);
}

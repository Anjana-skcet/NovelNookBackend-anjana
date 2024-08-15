package com.example.Book.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Book.dto.BestDTO;
import com.example.Book.dto.ReviewDTO;
import com.example.Book.entity.Best;
import com.example.Book.entity.Review;
import com.example.Book.repository.BestRepository;
import com.example.Book.service.BestService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BestServiceImpl implements BestService {

    @Autowired
    private BestRepository bestRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BestDTO createBook(BestDTO bestDTO) {
        // Map DTO to entity and save
        Best book = modelMapper.map(bestDTO, Best.class);
        book = bestRepository.save(book);
        return modelMapper.map(book, BestDTO.class);
    }

    @Override
    public BestDTO getBookById(Long bookId) {
        // Fetch book by ID
        Best book = bestRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return modelMapper.map(book, BestDTO.class);
    }

    @Override
    public List<BestDTO> getAllBooks() {
        // Get all books
        return bestRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BestDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BestDTO updateBook(Long bookId, BestDTO bestDTO) {
        // Update book details
        Best book = bestRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        modelMapper.map(bestDTO, book);
        book = bestRepository.save(book);
        return modelMapper.map(book, BestDTO.class);
    }

    @Override
    public void deleteBook(Long bookId) {
        // Delete book by ID
        bestRepository.deleteById(bookId);
    }

    @Override
    public void addReview(Long bookId, ReviewDTO reviewDTO) {
        // Add review to book
        Optional<Best> optionalBook = bestRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Best book = optionalBook.get();
            Review review = modelMapper.map(reviewDTO, Review.class);
            review.setBest(book);
            book.getReviews().add(review);
            bestRepository.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    @Override
    public List<ReviewDTO> getReviews(Long bookId) {
        // Get reviews for a book
        Optional<Best> optionalBook = bestRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Best book = optionalBook.get();
            return book.getReviews().stream()
                    .map(review -> modelMapper.map(review, ReviewDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Book not found");
        }
    }
}

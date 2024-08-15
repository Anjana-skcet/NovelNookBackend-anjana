package com.example.Book.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Book.dto.RecentDTO;
import com.example.Book.dto.ReviewrecDTO;
import com.example.Book.entity.Recent;
import com.example.Book.entity.Reviewrec;
import com.example.Book.repository.RecentRepository;
import com.example.Book.service.RecentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecentServiceImpl implements RecentService {

    @Autowired
    private RecentRepository recentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RecentDTO createRecentBook(RecentDTO recentDTO) {
        // Convert DTO to entity and save
        Recent recent = modelMapper.map(recentDTO, Recent.class);
        recent = recentRepository.save(recent);
        return modelMapper.map(recent, RecentDTO.class);
    }

    @Override
    public RecentDTO getRecentBookById(Long bookId) {
        // Fetch recent book by ID
        Recent recent = recentRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return modelMapper.map(recent, RecentDTO.class);
    }

    @Override
    public List<RecentDTO> getAllRecentBooks() {
        // Get all recent books
        return recentRepository.findAll().stream()
                .map(recent -> modelMapper.map(recent, RecentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecentDTO updateRecentBook(Long bookId, RecentDTO recentDTO) {
        // Update recent book details
        Recent recent = recentRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        modelMapper.map(recentDTO, recent);
        recent = recentRepository.save(recent);
        return modelMapper.map(recent, RecentDTO.class);
    }

    @Override
    public void deleteRecentBook(Long bookId) {
        // Delete recent book by ID
        recentRepository.deleteById(bookId);
    }

    @Override
    public void addReview(Long bookId, ReviewrecDTO reviewDTO) {
        // Add review to recent book
        Optional<Recent> optionalBook = recentRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Recent book = optionalBook.get();
            Reviewrec review = modelMapper.map(reviewDTO, Reviewrec.class);
            review.setRecent(book);
            book.getReviews().add(review);
            recentRepository.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    @Override
    public List<ReviewrecDTO> getReviews(Long bookId) {
        // Get reviews for recent book
        Optional<Recent> optionalBook = recentRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Recent book = optionalBook.get();
            return book.getReviews().stream()
                    .map(review -> modelMapper.map(review, ReviewrecDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Book not found");
        }
    }
}

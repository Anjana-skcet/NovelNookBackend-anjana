package com.example.Book.controller;

import com.example.Book.dto.BestDTO;
import com.example.Book.dto.ReviewDTO;
import com.example.Book.service.BestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/best")
@CrossOrigin
public class BestController {
    @Autowired
    private BestService bestService;

    //To post a new data
    @PostMapping
    public ResponseEntity<BestDTO> createBook(@RequestBody BestDTO bestDTO) {
        return ResponseEntity.ok(bestService.createBook(bestDTO));
    }

    //To fetch the data by id
    @GetMapping("/{bookId}")
    public ResponseEntity<BestDTO> getBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bestService.getBookById(bookId));
    }

    //To fetch all the data 
    @GetMapping
    public ResponseEntity<List<BestDTO>> getAllBooks() {
        return ResponseEntity.ok(bestService.getAllBooks());
    }

    //To update the data
    @PutMapping("/{bookId}")
    public ResponseEntity<BestDTO> updateBook(@PathVariable Long bookId, @RequestBody BestDTO bestDTO) {
        return ResponseEntity.ok(bestService.updateBook(bookId, bestDTO));
    }

    //To delete a data
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bestService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    //To post a data in review table
    @PostMapping("/{bookId}/reviews")
    public ResponseEntity<Void> addReview(@PathVariable Long bookId, @RequestBody ReviewDTO reviewDTO) {
        bestService.addReview(bookId, reviewDTO);
        return ResponseEntity.ok().build();
    }

    //To get the data from review table
    @GetMapping("/{bookId}/reviews")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long bookId) {
        List<ReviewDTO> reviews = bestService.getReviews(bookId);
        return ResponseEntity.ok(reviews);
    }
}

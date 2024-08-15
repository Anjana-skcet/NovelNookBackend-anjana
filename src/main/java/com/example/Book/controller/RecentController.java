package com.example.Book.controller;
import com.example.Book.dto.RecentDTO;
import com.example.Book.dto.ReviewDTO;
import com.example.Book.dto.ReviewrecDTO;
import com.example.Book.service.RecentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/recent")
@CrossOrigin
public class RecentController {
    @Autowired
    private RecentService recentService;
    
    //To post a new data
    @PostMapping
    public ResponseEntity<RecentDTO> createRecentBook(@RequestBody RecentDTO recentDTO) {
        return ResponseEntity.ok(recentService.createRecentBook(recentDTO));
    }

    //To fetch the data by id
    @GetMapping("/{bookId}")
    public ResponseEntity<RecentDTO> getRecentBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(recentService.getRecentBookById(bookId));
    }

    //To fetch all the data 
    @GetMapping
    public ResponseEntity<List<RecentDTO>> getAllRecentBooks() {
        return ResponseEntity.ok(recentService.getAllRecentBooks());
    }
    
    //To update the data
    @PutMapping("/{bookId}")
    public ResponseEntity<RecentDTO> updateRecentBook(@PathVariable Long bookId, @RequestBody RecentDTO recentDTO) {
        return ResponseEntity.ok(recentService.updateRecentBook(bookId, recentDTO));
    }

    //To delete a data
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteRecentBook(@PathVariable Long bookId) {
        recentService.deleteRecentBook(bookId);
        return ResponseEntity.noContent().build();
    }
    
    //To post a data in Reviewrec table
    @PostMapping("/{bookId}/reviews")
    public ResponseEntity<Void> addReview(@PathVariable Long bookId, @RequestBody ReviewrecDTO reviewDTO) {
        recentService.addReview(bookId, reviewDTO);
        return ResponseEntity.ok().build();
    }

    //To fetch the data from Reviewrec table
    @GetMapping("/{bookId}/reviews")
    public ResponseEntity<List<ReviewrecDTO>> getReviews(@PathVariable Long bookId) {
        List<ReviewrecDTO> reviews = recentService.getReviews(bookId);
        return ResponseEntity.ok(reviews);
    }
}

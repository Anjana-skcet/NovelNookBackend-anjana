package com.example.Book.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Book.dto.GenreDTO;
import com.example.Book.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@CrossOrigin
public class GenreController {
    @Autowired
    private GenreService userService;
    
   //To post a new data
    @PostMapping
    public ResponseEntity<GenreDTO> createUser(@RequestBody GenreDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    //To fetch the data by id
    @GetMapping("/{userId}")
    public ResponseEntity<GenreDTO> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    //To fetch all the data 
    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    //To fetch the data by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<GenreDTO>> getGenresByCategory(@PathVariable String category) {
        List<GenreDTO> genres = userService.getGenresByCategory(category);
        return ResponseEntity.ok(genres);
    }
    
    //To update the data
    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> updateUser(@PathVariable Long id, @RequestBody GenreDTO usersDTO) {
        return ResponseEntity.ok(userService.updateUser(id, usersDTO));
    }

    //To delete a data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
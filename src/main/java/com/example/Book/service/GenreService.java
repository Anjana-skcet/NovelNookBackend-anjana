package com.example.Book.service;

import java.util.List;
import com.example.Book.dto.GenreDTO;

public interface GenreService {

    // Create a genre
    GenreDTO createUser(GenreDTO userDTO);

    // Get a genre by ID
    GenreDTO getUserById(Long userId);

    // Get all genres
    List<GenreDTO> getAllUsers();

    // Update a genre
    GenreDTO updateUser(Long userId, GenreDTO usersDTO);

    // Delete a genre
    void deleteUser(Long userId);

    // Get genres by category
    List<GenreDTO> getGenresByCategory(String category);
}

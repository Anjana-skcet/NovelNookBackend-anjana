package com.example.Book.service;

import java.util.List;
import com.example.Book.dto.UserDTO;

public interface UserService {

    // Creates a new user and returns the created UserDTO
    UserDTO createUser(UserDTO userDTO);

    // Retrieves a user by id
    UserDTO getUserById(Long userId);

    // Retrieves a list of all users
    List<UserDTO> getAllUsers();

    // Updates an existing user's details
    UserDTO updateUser(Long userId, UserDTO userDTO);

    // Deletes a user 
    void deleteUser(Long userId);
}

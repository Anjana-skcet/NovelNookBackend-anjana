package com.example.Book.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Book.dto.GenreDTO;
import com.example.Book.entity.Genre;
import com.example.Book.repository.GenreRepository;
import com.example.Book.service.GenreService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GenreDTO createUser(GenreDTO genreDTO) {
        // Convert DTO to entity and save
        Genre genre = modelMapper.map(genreDTO, Genre.class);
        genre = genreRepository.save(genre);
        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public GenreDTO getUserById(Long userId) {
        // Fetch genre by ID
        Genre genre = genreRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public List<GenreDTO> getAllUsers() {
        // Get all genres
        return genreRepository.findAll().stream()
                .map(genre -> modelMapper.map(genre, GenreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GenreDTO updateUser(Long userId, GenreDTO genreDTO) {
        // Update genre details
        Genre genre = genreRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        modelMapper.map(genreDTO, genre);
        genre = genreRepository.save(genre);
        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        // Delete genre by ID
        genreRepository.deleteById(userId);
    }

    @Override
    public List<GenreDTO> getGenresByCategory(String category) {
        // Get genres by category
        List<Genre> genres = genreRepository.findByCategory(category);
        return genres.stream()
                .map(genre -> modelMapper.map(genre, GenreDTO.class))
                .collect(Collectors.toList());
    }
}

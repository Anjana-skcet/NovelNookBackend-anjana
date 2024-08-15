package com.example.Book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Book.entity.Genre;



@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> { 
	//JpaRepository provides CRUD operation for Genre entity
	List<Genre> findByCategory(String category);
}
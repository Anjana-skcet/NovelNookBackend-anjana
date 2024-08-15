package com.example.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Book.entity.Best;

@Repository
public interface BestRepository extends JpaRepository<Best, Long> { }
//JpaRepository provides CRUD operation for Best entity
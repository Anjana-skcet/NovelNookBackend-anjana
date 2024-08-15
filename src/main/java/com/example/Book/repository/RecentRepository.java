package com.example.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Book.entity.Recent;



@Repository
public interface RecentRepository extends JpaRepository<Recent, Long> { }
//JpaRepository provides CRUD operation for Recent entity
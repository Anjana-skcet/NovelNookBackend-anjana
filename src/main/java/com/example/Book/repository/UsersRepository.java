package com.example.Book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Book.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> { }
//JpaRepository provides CRUD operation for Users entity
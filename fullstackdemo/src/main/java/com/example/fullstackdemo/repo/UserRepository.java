package com.example.fullstackdemo.repo;

import com.example.fullstackdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

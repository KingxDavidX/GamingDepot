package com.example.Repositories;
import com.example.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposoitory extends JpaRepository<User, Integer> {
}

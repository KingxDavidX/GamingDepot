package com.example.user.repositories;
import com.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposoitory extends JpaRepository<User, Integer> {
}

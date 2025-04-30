package com.webchatbackend.WebChatBackend.repo;

import com.webchatbackend.WebChatBackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);

    @Query("SELECT u.ID FROM Users u WHERE u.username = :username")
    int getCurrentUserId(@Param("username") String username);
}

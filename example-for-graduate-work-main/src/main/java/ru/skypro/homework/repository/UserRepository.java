package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByEmail(String username);

    @Query(nativeQuery = true, value = "SELECT user_role FROM users WHERE user_email = :username")
    Optional<String> getRoleByEmail(String username);
}


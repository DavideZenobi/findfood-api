package io.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.spring.demo.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    @Query("SELECT COUNT (u) FROM User u WHERE u.nif = :nif")
    public int checkNif(@Param("nif") String nif);

    @Query("SELECT COUNT (u) FROM User u WHERE u.email = :email")
    public int checkEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

}

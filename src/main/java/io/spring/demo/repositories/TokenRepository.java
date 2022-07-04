package io.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.spring.demo.models.VerificationToken;

public interface TokenRepository extends JpaRepository<VerificationToken, String> {
    
    @Query("SELECT vt FROM VerificationToken vt WHERE vt.token = :token")
    public VerificationToken getVerificationTokenByToken(@Param("token") String token);
}

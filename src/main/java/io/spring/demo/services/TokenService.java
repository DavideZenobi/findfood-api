package io.spring.demo.services;

import org.springframework.stereotype.Service;

import io.spring.demo.models.VerificationToken;
import io.spring.demo.repositories.TokenRepository;

@Service
public class TokenService {
    
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public VerificationToken getVerificationToken(String token) {
        VerificationToken verificationToken = tokenRepository.getVerificationTokenByToken(token);
        return verificationToken;
    }

    public void createVerificationToken(int userId, String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUserId(userId);
        verificationToken.setToken(token);
        tokenRepository.save(verificationToken);
    }
}

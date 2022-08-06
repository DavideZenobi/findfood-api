package io.spring.demo.security;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.spring.demo.exception.GenericApiException;
import io.spring.demo.models.User;
import io.spring.demo.services.UserService;

@Component
public class ApplicationAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationAuthenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String inputUsername = (String) authentication.getPrincipal();
        String inputPassword = (String) authentication.getCredentials();
        
        if (userService.getUserByEmail(inputUsername) == null) {
            throw new GenericApiException("El usuario no existe");
        }
        User user = userService.getUserByEmail(inputUsername);
        String username = user.getEmail();
        String password = user.getPassword();

        if (username.equals(inputUsername) && passwordEncoder.matches(inputPassword, password)) {
            return new UsernamePasswordAuthenticationToken(inputUsername, inputPassword, Collections.emptyList());
        } else {
            return null;
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    
    
}

package io.spring.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.spring.demo.models.User;
import io.spring.demo.models.VerificationToken;
import io.spring.demo.services.TokenService;
import io.spring.demo.services.UserService;

@RestController
@RequestMapping(name = "/api")
public class RegistrationController {
    
    private TokenService tokenService;
    private UserService userService;

    public RegistrationController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @GetMapping("/registrationConfirm")
    public String confirmRegistration(@RequestParam("token") String token) {
        VerificationToken verificationToken = tokenService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = "";
            return message;
        }

        User user = userService.getUserById(verificationToken.getUserId());
        user.setStatus(true);
        userService.saveUser(user);
        return "";
    }
}

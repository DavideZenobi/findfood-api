package io.spring.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.demo.dto.UserShopRegisterInputDTO;
import io.spring.demo.models.Shop;
import io.spring.demo.models.User;
import io.spring.demo.services.AdvancedService;
import io.spring.demo.services.ConverterService;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    
    private final ConverterService converterService;
    private final AdvancedService advancedService;
    

    public UserController(ConverterService converterService, AdvancedService advancedService) {
        this.converterService = converterService;
        this.advancedService = advancedService;
    }

    @GetMapping(path = "/{userId}")
    public void getUserById(@PathVariable int userId) {

    }

    @GetMapping(path = "/me")
    public ResponseEntity<Void> getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "")
    public void registerUserAndShop(@RequestBody UserShopRegisterInputDTO dto) {
        User user = converterService.dtoToUser(dto);
        Shop shop = converterService.dtoToShop(dto);
        advancedService.registerUserAndShop(user, shop);
    }
}

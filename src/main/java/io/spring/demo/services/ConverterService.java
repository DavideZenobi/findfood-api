package io.spring.demo.services;

import org.springframework.stereotype.Service;

import io.spring.demo.dto.UserShopRegisterInputDTO;
import io.spring.demo.models.Shop;
import io.spring.demo.models.User;

@Service
public class ConverterService {
    
    public User dtoToUser(UserShopRegisterInputDTO dto) {
        User user = new User();
        user.setNif(dto.getNif());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        return user;
    }

    public Shop dtoToShop(UserShopRegisterInputDTO dto) {
        Shop shop = new Shop();
        shop.setName(dto.getShopName());
        shop.setAddress(dto.getAddress());
        shop.setAutonomousCommunity(dto.getAutonomousCommunity());
        shop.setProvince(dto.getProvince());
        shop.setMunicipality(dto.getMunicipality());
        return shop;
    }

}

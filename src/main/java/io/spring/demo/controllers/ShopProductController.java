package io.spring.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/shopProduct")
public class ShopProductController {
    
    public ShopProductController() {

    }

    @GetMapping(path = "/")
    public void getShopProductsByProductId() {

    }
}

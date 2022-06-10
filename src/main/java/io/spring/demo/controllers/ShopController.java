package io.spring.demo.controllers;

import io.spring.demo.models.Shop;
import io.spring.demo.services.AdvancedService;
import io.spring.demo.services.ShopService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/shop")
public class ShopController {
    
    private final ShopService shopService;
    private final AdvancedService advancedService;

    public ShopController(ShopService shopService, AdvancedService advancedService) {
        this.shopService = shopService;
        this.advancedService = advancedService;
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shop> searchShops() {
        List<Shop> shops = shopService.findAll();
        return shops;
    }

    @GetMapping(path = "/shopsByProductId")
    public List<Shop> getShopsByProductId(@RequestParam(name = "productId") int productId) {
        List<Shop> shops = advancedService.getShopsWithPriceByProductId(productId);
        return shops;
    }

}

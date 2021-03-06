package io.spring.demo.controllers;

import io.spring.demo.models.ShopsListCount;
import io.spring.demo.services.AdvancedService;
import io.spring.demo.services.ShopService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/shop")
public class ShopController {
    
    private final ShopService shopService;
    private final AdvancedService advancedService;

    public ShopController(ShopService shopService, AdvancedService advancedService) {
        this.shopService = shopService;
        this.advancedService = advancedService;
    }

    @GetMapping(path = "/search")
    public ShopsListCount searchProduct(@RequestParam int productId, @RequestParam int page) {
        ShopsListCount shops = advancedService.getShopsByProductId(productId, page);
        return shops;
    }

}

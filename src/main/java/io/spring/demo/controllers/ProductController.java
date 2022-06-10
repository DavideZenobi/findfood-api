package io.spring.demo.controllers;

import io.spring.demo.models.Product;
import io.spring.demo.services.AdvancedService;
//import io.spring.demo.models.ProductShop;
import io.spring.demo.services.ProductService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private final AdvancedService advancedService;
    private final ProductService productService;

    public ProductController(AdvancedService advancedService, ProductService productService) {
        this.advancedService = advancedService;
        this.productService = productService;
    }

    @GetMapping(path = "/single", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductById(@RequestParam(name = "input") int id) {
        Product product = productService.getProductById(id);
        return product;
    }

    @GetMapping(path = "/productsWithPrice", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsWithPriceByName(@RequestParam(name = "input") String name) {
        List<Product> products = advancedService.getProductsWithPriceAndShopsCountByName(name);
        return products;
    }

    @GetMapping(path = "/random")
    public List<Product> getRandomProductsWithPrice() {
        List<Product> randomProducts = advancedService.getRandomProductsWithPriceAndShopsCount();
        return randomProducts;
    }

}

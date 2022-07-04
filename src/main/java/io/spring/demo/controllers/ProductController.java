package io.spring.demo.controllers;

import io.spring.demo.models.Product;
import io.spring.demo.services.AdvancedService;
//import io.spring.demo.models.ProductShop;
import io.spring.demo.services.ProductService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductById(@PathVariable int productId) {
        Product product = productService.getProductById(productId);
        return product;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsByText(@RequestParam String text) {
        List<Product> products = advancedService.getProductsByName(text);
        return products;
    }

    @GetMapping(path = "/V2", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsByTextV2(@RequestParam String text) {
        List<Product> products = productService.getProductsByNameContains(text);
        return products;
    }

    @GetMapping(path = "/random")
    public List<Product> getRandomProducts() {
        List<Product> randomProducts = advancedService.getRandomProducts();
        return randomProducts;
    }

    @PutMapping(path = "/{productId}/view")
    public int addView(@PathVariable int productId) {
        int isOk = productService.addView(productId);
        return isOk;
    }

}

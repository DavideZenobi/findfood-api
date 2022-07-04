package io.spring.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spring.demo.models.Product;
import io.spring.demo.repositories.ProductRepository;
import io.spring.demo.repositories.ShopProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    private final ShopProductRepository shopProductRepository;

    public ProductService(ProductRepository productRepository, ShopProductRepository shopProductRepository) {
        this.productRepository = productRepository;
        this.shopProductRepository = shopProductRepository;
    }

    //Return single product
    public Product getProductById(int id) {
        Product product = productRepository.getById(id);
        return product;
    }

    //Return list of products with given name
    public List<Product> getProductsByNameContains(String name) {
        List<Product> products = productRepository.findByNameContains(name);
        return products;
    }

    public List<Product> getRandomProducts() {
        List<Product> products = productRepository.findFiveRandom();
        return products;
    }

    @Transactional
    public int addView(int productId) {
        int timesVisited = productRepository.getViews(productId);
        timesVisited = timesVisited + 1;
        int isOk = productRepository.addView(productId, timesVisited);
        return isOk;
    }
    
}

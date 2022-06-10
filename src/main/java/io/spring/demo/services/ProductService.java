package io.spring.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

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

    //Returns the products with the lowest price among all shops given a name
    public List<Product> getProductsWithPriceByName(String name) {
        List<Product> products = productRepository.findByNameContains(name);

        for (Product product : products) {
            Float price = shopProductRepository.getLowestPriceByProductId(product.getId());
            if (price != null) {
                product.setPrice(price);
            }
        }

        return products;
    }

    //
    public List<Product> getProductsWithPriceAndShopsCountByName(String name) {
        List<Product> products = productRepository.findByNameContains(name);

        for (Product product : products) {
            Float price = shopProductRepository.getLowestPriceByProductId(product.getId());
            if (price != null) {
                product.setPrice(price);
            }

            product.setShopsCount(shopProductRepository.getShopsCountByProductId(product.getId()));
        }

        return products;
    }

    //Return five random products with the lowest price among all shops
    public List<Product> getFiveRandomProductsWithPrice() {
        List<Product> products = productRepository.findFiveRandom();

        for (Product product : products) {
            Float price = shopProductRepository.getLowestPriceByProductId(product.getId());
            if (price != null) {
                product.setPrice(price);
            }

            product.setShopsCount(shopProductRepository.getShopsCountByProductId(product.getId()));
        }

        return products;
    }
}

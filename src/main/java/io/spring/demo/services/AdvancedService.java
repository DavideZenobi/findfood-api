package io.spring.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.demo.models.Product;
import io.spring.demo.models.Shop;

@Service
public class AdvancedService {
    
    private final ProductService productService;
    private final ShopService shopService;
    private final ShopProductService shopProductService;

    public AdvancedService(
        ProductService productService,
        ShopService shopService,
        ShopProductService shopProductService
    ) {
        this.productService = productService;
        this.shopService = shopService;
        this.shopProductService = shopProductService;
    }

    //Only for autocomplete purposes
    public List<Product> getProductsWithPriceAndShopsCountByName(String name) {
        List<Product> products = productService.getProductsByNameContains(name);

        for (Product product : products) {
            Float price = shopProductService.getLowestPriceByProductId(product.getId());
            if (price != null) {
                product.setPrice(price);
            }

            int shopsCount = shopProductService.getShopsCountByProductId(product.getId());
            product.setShopsCount(shopsCount);
        }

        return products;
    }

    //Return products with lowest price and how many shops are selling it
    public List<Product> getRandomProductsWithPriceAndShopsCount() {
        List<Product> products = productService.getRandomProducts();

        for (Product product : products) {
            Float price = shopProductService.getLowestPriceByProductId(product.getId());
            if (price != null) {
                product.setPrice(price);
            }

            int shopsCount = shopProductService.getShopsCountByProductId(product.getId());
            product.setShopsCount(shopsCount);
        }

        return products;
    }

    //
    public List<Shop> getShopsWithPriceByProductId(int productId) {
        List<String> nifs = shopProductService.getNifsByProductId(productId);
        List<Shop> shops = shopService.getShopsByNifs(nifs);

        for (Shop shop : shops) {
            Float price = shopProductService.getPriceByNifAndProductId(shop.getNif(), productId);
            shop.setPrice(price);
        }

        return shops;
    }
}

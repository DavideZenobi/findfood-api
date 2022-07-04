package io.spring.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.demo.repositories.ShopProductRepository;

@Service
public class ShopProductService {

    private final ShopProductRepository shopProductRepository;

    public ShopProductService(ShopProductRepository shopProductRepository) {
        this.shopProductRepository = shopProductRepository;
    }

    public Float getLowestPriceByProductId(int productId) {
        Float price = shopProductRepository.getLowestPriceByProductId(productId);
        return price;
    }

    public int getShopsCountByProductId(int productId) {
        int shopsCount = shopProductRepository.getShopsCountByProductId(productId);
        return shopsCount;
    }

    public List<String> getIdsByProductId(int productId) {
        List<String> ids = shopProductRepository.getIdsByProductId(productId);
        return ids;
    }

    public Float getPriceByIdAndProductId(String id, int productId) {
        Float price = shopProductRepository.getPriceByIdAndProductId(id, productId);
        return price;
    }
    
}

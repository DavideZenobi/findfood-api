package io.spring.demo.services;

import io.spring.demo.models.Shop;
import io.spring.demo.repositories.ShopRepository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop getShopByNif(String nif) {
        Shop shop = shopRepository.getByNif(nif);
        return shop;
    }

    public List<Shop> getShopsByNifs(List<String> nifs, int page) { 
        int size = 10;
        Page<Shop> shops = shopRepository.getByNifs(nifs, PageRequest.of(page, size));

        return shops;
    }

}

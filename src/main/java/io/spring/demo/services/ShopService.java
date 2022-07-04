package io.spring.demo.services;

import io.spring.demo.models.Shop;
import io.spring.demo.repositories.ShopRepository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop getShopById(String id) {
        Shop shop = shopRepository.getById(id);
        return shop;
    }

    public Page<Shop> getShopsByIds(List<String> ids, int page) { 
        int size = 5;
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Shop> shops = shopRepository.getByIds(ids, pageable);

        return shops;
    }

    public Shop saveShop(Shop shop) {
        Shop shopCreated = shopRepository.save(shop);
        return shopCreated;
    }

    public boolean checkIfShopExist(String id) {
        if(shopRepository.checkId(id) == 1) {
            return true;
        } else {
            return false;
        }
    }

}

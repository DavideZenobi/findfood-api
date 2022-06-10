package io.spring.demo.services;

import io.spring.demo.models.Shop;
import io.spring.demo.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ShopService {
    
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> findAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops;
    }

    public List<Shop> getShopsByNifs(List<String> nifs) {
        List<Shop> shops = new ArrayList<Shop>(nifs.size());
        for (String nif : nifs) {
            shops.add(shopRepository.getByNif(nif));
        }

        return shops;
    }

    public Shop getShopByNif(String nif) {
        Shop shop = shopRepository.getByNif(nif);
        return shop;
    }

    public void findShopsByProduct() {

    }


}

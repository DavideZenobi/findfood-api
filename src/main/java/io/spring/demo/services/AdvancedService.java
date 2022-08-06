package io.spring.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spring.demo.dto.UserShopRegisterOutputDTO;
import io.spring.demo.events.OnRegistrationEvent;
import io.spring.demo.exception.GenericApiException;
import io.spring.demo.models.Product;
import io.spring.demo.models.Shop;
import io.spring.demo.models.ShopsListCount;
import io.spring.demo.models.User;

@Service
public class AdvancedService {
    
    private final ProductService productService;
    private final ShopService shopService;
    private final ShopProductService shopProductService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AdvancedService(
        ProductService productService,
        ShopService shopService,
        ShopProductService shopProductService,
        UserService userService,
        PasswordEncoder passwordEncoder,
        ApplicationEventPublisher applicationEventPublisher
    ) {
        this.productService = productService;
        this.shopService = shopService;
        this.shopProductService = shopProductService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    //Only for autocomplete purposes
    public List<Product> getProductsByName(String name) {
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
    public List<Product> getRandomProducts() {
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

    public ShopsListCount getShopsByProductId(int productId, int page) {
        ShopsListCount shopsList = new ShopsListCount();
        List<String> ids = shopProductService.getIdsByProductId(productId);
        Page<Shop> shopsPage = shopService.getShopsByIds(ids, page);

        for (Shop shop : shopsPage) {
            Float price = shopProductService.getPriceByIdAndProductId(shop.getId(), productId);
            shop.setPrice(price);
        }
        List<Shop> shops = shopsPage.getContent();
        shopsList.setShops(shops);
        shopsList.setShopsCount(shopsPage.getTotalElements());

        return shopsList;
    }

    @Transactional
    public void registerUserAndShop(User user, Shop shop) {
        if (userService.checkIfUserExist(user.getNif(), user.getEmail())) {
            throw new GenericApiException("El usuario ya existe");
        } 

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setStatus(false);
        user.setRolId(1);
        user.setDateCreated(LocalDateTime.now());
        User userCreated = userService.saveUser(user);

        shop.setId(user.getNif());
        if (shopService.checkIfShopExist(shop.getId())) {
            throw new GenericApiException("La tienda ya existe");
        }

        shop.setStatus(false);
        shop.setDateCreated(LocalDateTime.now());
        shopService.saveShop(shop);

        //applicationEventPublisher.publishEvent(new OnRegistrationEvent(userCreated));
        
    }

}

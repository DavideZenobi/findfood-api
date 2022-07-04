package io.spring.demo.models;

import java.util.List;

public class ShopsListCount {

    private List<Shop> shops;
    private Long shopsCount;
    
    public List<Shop> getShops() {
        return shops;
    }
    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
    public Long getShopsCount() {
        return shopsCount;
    }
    public void setShopsCount(Long shopsCount) {
        this.shopsCount = shopsCount;
    }
    
    
}

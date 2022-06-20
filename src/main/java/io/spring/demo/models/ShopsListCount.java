package io.spring.demo.models;

import java.util.List;

public class ShopsListCount {

    private List<Shop> shops;
    private int shopsCount;
    
    public List<Shop> getShops() {
        return shops;
    }
    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
    public int getShopsCount() {
        return shopsCount;
    }
    public void setShopsCount(int shopsCount) {
        this.shopsCount = shopsCount;
    }
    
    
}

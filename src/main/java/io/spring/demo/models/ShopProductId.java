package io.spring.demo.models;

import java.io.Serializable;

public class ShopProductId implements Serializable {
    
    private String idShop;
    private int idProduct;

    public String getIdShop() {
        return idShop;
    }
    public void setIdShop(String idShop) {
        this.idShop = idShop;
    }
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    
}

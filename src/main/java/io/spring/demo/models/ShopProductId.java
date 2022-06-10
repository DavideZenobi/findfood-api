package io.spring.demo.models;

import java.io.Serializable;

public class ShopProductId implements Serializable {
    
    private String nifShop;
    private int idProduct;

    public String getNifShop() {
        return nifShop;
    }
    public void setNifShop(String nifShop) {
        this.nifShop = nifShop;
    }
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    
}

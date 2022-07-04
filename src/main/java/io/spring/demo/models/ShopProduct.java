package io.spring.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "shop_product")
@IdClass(ShopProductId.class)
public class ShopProduct implements Serializable {
    
    @Id
    @Column(name = "id_shop")
    private String idShop;

    @Id
    @Column(name = "id_product")
    private int idProduct;

    @Column(name = "price")
    private Float price;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    

}
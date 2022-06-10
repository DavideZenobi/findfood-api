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
    @Column(name = "nif_shop")
    private String nifShop;

    @Id
    @Column(name = "id_product")
    private int idProduct;

    @Column(name = "price")
    private Float price;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    

}
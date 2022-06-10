package io.spring.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "shop")
public class Shop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nif")
    private String nif;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "autonomousCommunity")
    private String autonomousCommunity;

    @Column(name = "province")
    private String province;

    @Column(name = "municipality")
    private String municipality;

    @Transient
    private Float price;

    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAutonomousCommunity() {
        return autonomousCommunity;
    }

    public void setAutonomousCommunity(String autonomousCommunity) {
        this.autonomousCommunity = autonomousCommunity;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }

    

}

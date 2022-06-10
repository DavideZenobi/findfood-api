package io.spring.demo.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "weight")
    private String weight;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "times_visited")
    private Integer timesVisited;

    @Transient
    private float price;

    @Transient
    private int shopsCount;
    
    public int getShopsCount() {
        return shopsCount;
    }
    public void setShopsCount(int shopsCount) {
        this.shopsCount = shopsCount;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Integer getTimesVisited() {
        return timesVisited;
    }
    public void setTimesVisited(Integer timesVisited) {
        this.timesVisited = timesVisited;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}

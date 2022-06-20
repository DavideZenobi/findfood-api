package io.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.spring.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    public Product getById(@Param("id") int id);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name%")
    public List<Product> findByNameContains(@Param("name") String name);

    public List<Product> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM Product p ORDER BY RAND() LIMIT 5")
    public List<Product> findFiveRandom();

    @Query("SELECT p FROM Product p WHERE p.brand = :brand")
    public List<Product> getProductsByBrand(@Param("brand") String brand);

}

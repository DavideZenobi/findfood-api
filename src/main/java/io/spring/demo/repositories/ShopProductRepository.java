package io.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.spring.demo.models.ShopProduct;
import io.spring.demo.models.ShopProductId;

public interface ShopProductRepository extends JpaRepository<ShopProduct, ShopProductId> {

    @Query("SELECT MIN(sp.price) FROM ShopProduct sp WHERE sp.idProduct = :productId")
    public Float getLowestPriceByProductId(@Param("productId") int productId);

    @Query("SELECT sp FROM ShopProduct sp WHERE sp.idProduct = :productId")
    public void getAllByProductId(@Param("productId") int productId);

    @Query("SELECT sp.idShop FROM ShopProduct sp WHERE sp.idProduct = :productId")
    public List<String> getIdsByProductId(@Param("productId") int productId);

    @Query("SELECT COUNT(sp.idProduct) FROM ShopProduct sp WHERE sp.idProduct = :productId")
    public int getShopsCountByProductId(@Param("productId") int productId);

    @Query("SELECT sp.price FROM ShopProduct sp WHERE sp.idShop = :id AND sp.idProduct = :productId")
    public Float getPriceByIdAndProductId(@Param("id") String id, @Param("productId") int productId);
    
}

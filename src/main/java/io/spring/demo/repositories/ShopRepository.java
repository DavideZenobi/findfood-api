package io.spring.demo.repositories;

import io.spring.demo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
    
    @Query("SELECT s FROM Shop s WHERE s.nif = :nif")
    public Shop getByNif(@Param("nif") String nif);

}

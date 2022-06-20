package io.spring.demo.repositories;

import io.spring.demo.models.Shop;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
    
    @Query("SELECT s FROM Shop s WHERE s.nif = :nif")
    public Shop getByNif(@Param("nif") String nif);

    @Query("SELECT s FROM Shop s WHERE s.nif in :nifs")
    public Page<Shop> getByNifs(@Param("nifs") List<String> nifs, Pageable page);

}

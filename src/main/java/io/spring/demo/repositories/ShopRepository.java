package io.spring.demo.repositories;

import io.spring.demo.models.Shop;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
    
    @Query("SELECT s FROM Shop s WHERE s.id = :id")
    public Shop getById(@Param("id") String id);

    @Query("SELECT s FROM Shop s WHERE s.id in :ids")
    public Page<Shop> getByIds(@Param("ids") List<String> ids, Pageable pageable);

    @Query("SELECT COUNT (s) FROM Shop s WHERE s.id = :id")
    public int checkId(@Param("id") String id);

}

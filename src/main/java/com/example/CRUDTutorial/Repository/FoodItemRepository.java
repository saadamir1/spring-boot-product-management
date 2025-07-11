package com.example.CRUDTutorial.Repository;

import com.example.CRUDTutorial.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findAllByExpiryDateBefore(Date currentDate);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM FoodItem f WHERE f.product.id = :productId")
    void deleteByProductId(@Param("productId") Long productId);
}
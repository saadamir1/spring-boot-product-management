package com.example.CRUDTutorial.Repository;

import com.example.CRUDTutorial.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findAllByExpiryDateBefore(Date currentDate);

}
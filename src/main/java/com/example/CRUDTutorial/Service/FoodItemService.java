package com.example.CRUDTutorial.Service;

import com.example.CRUDTutorial.Model.FoodItem;

import java.util.Date;
import java.util.List;

public interface FoodItemService {
    List<FoodItem> getAllExpiredProducts();
    void deleteFoodItemById(Long foodItemId);
    void addFoodItem(FoodItem foodItem);
}
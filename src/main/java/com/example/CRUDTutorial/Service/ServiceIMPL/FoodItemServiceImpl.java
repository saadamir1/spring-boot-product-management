package com.example.CRUDTutorial.Service.ServiceIMPL;

import com.example.CRUDTutorial.Model.FoodItem;
import com.example.CRUDTutorial.Repository.FoodItemRepository;
import com.example.CRUDTutorial.Repository.ProductRepository;
import com.example.CRUDTutorial.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    
    private final FoodItemRepository foodItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public FoodItemServiceImpl(FoodItemRepository foodItemRepository, ProductRepository productRepository) {
        this.foodItemRepository = foodItemRepository;
        this.productRepository = productRepository;
    }

    public List<FoodItem> getAllExpiredProducts() {
        Date currentDate = new Date();
        return foodItemRepository.findAllByExpiryDateBefore(currentDate);
    }

    @Override
    public void deleteFoodItemById(Long foodItemId) {
        if (!foodItemRepository.existsById(foodItemId)) {
            throw new RuntimeException("FoodItem with ID " + foodItemId + " not found!");
        }
        foodItemRepository.deleteById(foodItemId);
    }

    @Override
    public void addFoodItem(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }
}
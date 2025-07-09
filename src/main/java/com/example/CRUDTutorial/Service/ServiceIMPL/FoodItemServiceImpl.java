package com.example.CRUDTutorial.Service.ServiceIMPL;
import com.example.CRUDTutorial.Model.FoodItem;
import com.example.CRUDTutorial.Model.Product;
import com.example.CRUDTutorial.Repository.FoodItemRepository;
import com.example.CRUDTutorial.Repository.ProductRepository;
import com.example.CRUDTutorial.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
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
        foodItemRepository.deleteById(foodItemId);
    }

    @Override
    public void addFoodItem(FoodItem foodItem) {// Example logging in the service method
        System.out.println("Saving FoodItem: " + foodItem);
        foodItemRepository.save(foodItem);
        System.out.println("FoodItem saved successfully!");
    }
}

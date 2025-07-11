package com.example.CRUDTutorial.Service.ServiceIMPL;

import com.example.CRUDTutorial.Model.Product;
import com.example.CRUDTutorial.Repository.ProductRepository;
import com.example.CRUDTutorial.Repository.FoodItemRepository;
import com.example.CRUDTutorial.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public Product addProduct(Product product) {
        product.setSku(generateSku());
        return productRepository.save(product);
    }

    public String generateSku() {
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000);
        return "PPK" + randomNumber;
    }

    @Override
    public List<Product> listOfProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long productId) {
        // Check if product exists first
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product with ID " + productId + " not found!");
        }
        
        // First delete all associated FoodItems
        foodItemRepository.deleteByProductId(productId);
        // Then delete the Product
        productRepository.deleteById(productId);
    }

    @Override
    public Product findByID(Long productId) {
        return productRepository.findById(productId).orElseThrow(()->
                new RuntimeException("Product with ID " + productId + " not found!")
        );
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(()->
                new RuntimeException("Product with ID " + id + " not found!")
        );
        updatedProduct.setId(id);
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        return productRepository.save(updatedProduct);
    }
}
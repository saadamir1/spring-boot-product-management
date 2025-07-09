package com.example.CRUDTutorial.Service.ServiceIMPL;

import com.example.CRUDTutorial.Model.Product;
import com.example.CRUDTutorial.Repository.ProductRepository;
import com.example.CRUDTutorial.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {

        product.setSku(generateSku());
        return productRepository.save(product);
    }

    public String generateSku() {
        // Generate a random 6-digit number
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000);

        // Combine "PPK" with the random number to form the SKU
        String sku = "PPK" + randomNumber;

        return sku;
    }

    @Override
    public List<Product> listOfProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product findByID(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->
                new RuntimeException("ID not found!")
                );
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(()->
                new RuntimeException("ID not found!")
        );
        updatedProduct.setId(id);
        //updatedProduct.setSku(product.getSku());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        productRepository.save(updatedProduct);

        return product;
    }
}

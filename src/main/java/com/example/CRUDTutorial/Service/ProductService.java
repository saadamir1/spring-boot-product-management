package com.example.CRUDTutorial.Service;

import com.example.CRUDTutorial.Model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> listOfProduct();
    void deleteProduct(Long id);
    Product findByID(Long id);
    Product updateProduct(Long id, Product product);
}

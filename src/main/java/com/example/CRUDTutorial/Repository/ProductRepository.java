package com.example.CRUDTutorial.Repository;

import com.example.CRUDTutorial.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product,Long> {

}

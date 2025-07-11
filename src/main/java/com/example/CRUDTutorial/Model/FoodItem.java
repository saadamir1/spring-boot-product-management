package com.example.CRUDTutorial.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FoodItem")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    @JoinColumn(name = "foodProductId", referencedColumnName = "id")
    private Product product;

    @Column(name = "expiryDate")
    private Date expiryDate;

    public FoodItem() {
    }

    public FoodItem(Long id, Product product, Date expiryDate) {  // Change the type in the constructor
        this.id = id;
        this.product = product;
        this.expiryDate = expiryDate;
    }

    public Long getId() {  // Change the return type
        return id;
    }

    public void setId(Long id) {  // Change the parameter type
        this.id = id;
    }

    public Product getFoodProduct() {
        return product;
    }

    public void setFoodProduct(Product product) {
        this.product = product;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}

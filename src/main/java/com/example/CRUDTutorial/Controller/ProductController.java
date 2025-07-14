package com.example.CRUDTutorial.Controller;

import com.example.CRUDTutorial.Model.FoodItem;
import com.example.CRUDTutorial.Model.Product;
import com.example.CRUDTutorial.Service.FoodItemService;
import com.example.CRUDTutorial.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/")
    public String productList(Model model) {
        List<Product> products = productService.listOfProduct();
        model.addAttribute("products", products);

        // Add an empty Product object to the model for form binding
        model.addAttribute("product", new Product());
        model.addAttribute("foodItem", new FoodItem());

        return "product/index";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/Save")
    public String saveProduct(@ModelAttribute FoodItem foodItem) {
        productService.addProduct(foodItem.getFoodProduct());
        foodItemService.addFoodItem(foodItem);

        return "redirect:/products/";
    }

    @GetMapping("/findByID/{id}")
    @ResponseBody
    public Product findByID(@PathVariable Long id) {
        return productService.findByID(id);
    }

    @GetMapping("/deleteByID/{id}")
    public String deleteProduct(@PathVariable(value = "id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products/";
    }
    @PostMapping("/updateByID/{id}")
    public String updateByID(@PathVariable(name = "id") Long id, @ModelAttribute Product product, Model model) {
        productService.updateProduct(id, product);
        return "redirect:/products/";
    }
    @GetMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @GetMapping("/expiredProducts")
    public String showExpiredProducts(Model model) {
        List<FoodItem> expiredProducts = foodItemService.getAllExpiredProducts();
        model.addAttribute("expiredProducts", expiredProducts);

        return "product/expiredProducts";
    }
}



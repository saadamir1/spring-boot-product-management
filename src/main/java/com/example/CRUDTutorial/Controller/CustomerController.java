package com.example.CRUDTutorial.Controller;

import com.example.CRUDTutorial.Model.Customer;
import com.example.CRUDTutorial.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String customerList(Model model) {
        List<Customer> customers = customerService.listOfCustomers();
        model.addAttribute("customers", customers);

        // Add an empty Customer object to the model for form binding
        model.addAttribute("customer", new Customer());


        return "customer/index";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customers/";
    }

    @GetMapping("/findCustomerByID/{customerID}")
    @ResponseBody
    public Customer findCustomerByID(@PathVariable int customerID) {
        return customerService.findByID(customerID);
    }

    @GetMapping("/deleteCustomerByID/{customerID}")
    public String deleteCustomerByID(@PathVariable(value = "customerID") int customerID) {
        customerService.deleteCustomer(customerID);
        return "redirect:/customers/";
    }

    @PostMapping("/updateCustomerByID/{id}")
    public String updateCustomerByID(@PathVariable(name = "id") int customerID, @ModelAttribute Customer customer, Model model) {
        customerService.updateCustomer(customerID, customer);
        return "redirect:/customers/";
    }

    @GetMapping("/addCustomer")
    public String addCustomer() {
        return "customer/addCustomer";
    }
}

package com.example.CRUDTutorial.Service;

import com.example.CRUDTutorial.Model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> listOfCustomers();
    void deleteCustomer(int customerId);
    Customer findByID(int customerId);
    Customer updateCustomer(int customerId, Customer customer);
}

package com.example.CRUDTutorial.Service.ServiceIMPL;

import com.example.CRUDTutorial.Model.Customer;
import com.example.CRUDTutorial.Repository.CustomerRepository;
import com.example.CRUDTutorial.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> listOfCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer findByID(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer updateCustomer(int customerId, Customer customer) {
        Customer updatedCustomer = customerRepository.findById(customerId).orElse(null);
        if (updatedCustomer != null) {
            // Update customer details
            updatedCustomer.setBusinessName(customer.getBusinessName());
            updatedCustomer.setAddress(customer.getAddress());
            updatedCustomer.setTelephoneNumber(customer.getTelephoneNumber());
            customerRepository.save(updatedCustomer);
        }
        return updatedCustomer;
    }
}

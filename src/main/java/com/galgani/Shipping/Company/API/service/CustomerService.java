package com.galgani.Shipping.Company.API.service;

import com.galgani.Shipping.Company.API.dto.request.NewCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.SearchCustomerRequest;
import com.galgani.Shipping.Company.API.dto.response.CustomerResponse;
import com.galgani.Shipping.Company.API.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService {
    Customer create(NewCustomerRequest customer);
    Customer getById(String id);
    Page<Customer> searchCustomer(SearchCustomerRequest searchCustomerRequest);
    CustomerResponse update(Customer customer);
    void deleteById(String id);
}

package com.galgani.Shipping.Company.API.service;

import com.galgani.Shipping.Company.API.dto.request.NewCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.SearchCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.UpdateCustomerRequest;
import com.galgani.Shipping.Company.API.dto.response.CustomerResponse;
import com.galgani.Shipping.Company.API.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerService {
    Customer create(NewCustomerRequest newCustomerRequest);
    Customer getById(String id);
    List<Customer> searchCustomer(SearchCustomerRequest searchCustomerRequest);
    CustomerResponse update(UpdateCustomerRequest updateCustomerRequest);
    void deleteById(String id);
}

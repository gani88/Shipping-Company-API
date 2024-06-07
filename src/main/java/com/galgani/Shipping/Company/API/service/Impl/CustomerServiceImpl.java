package com.galgani.Shipping.Company.API.service.Impl;

import com.galgani.Shipping.Company.API.dto.request.NewCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.SearchCustomerRequest;
import com.galgani.Shipping.Company.API.dto.response.CustomerResponse;
import com.galgani.Shipping.Company.API.entity.Customer;
import com.galgani.Shipping.Company.API.service.CustomerService;
import org.springframework.data.domain.Page;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer create(NewCustomerRequest customer) {
        return null;
    }

    @Override
    public Customer getById(String id) {
        return null;
    }

    @Override
    public Page<Customer> searchCustomer(SearchCustomerRequest searchCustomerRequest) {
        return null;
    }

    @Override
    public CustomerResponse update(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}

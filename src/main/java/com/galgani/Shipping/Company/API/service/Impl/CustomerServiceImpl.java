package com.galgani.Shipping.Company.API.service.Impl;

import com.galgani.Shipping.Company.API.dto.request.NewCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.SearchCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.UpdateCustomerRequest;
import com.galgani.Shipping.Company.API.dto.response.CustomerResponse;
import com.galgani.Shipping.Company.API.entity.Customer;
import com.galgani.Shipping.Company.API.repository.CustomerRepository;
import com.galgani.Shipping.Company.API.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(NewCustomerRequest newCustomerRequest) {
        Customer newCustomer = Customer.builder()
                .customerName(newCustomerRequest.getCustomerName())
                .email(newCustomerRequest.getEmail())
                .address(newCustomerRequest.getAddress())
                .build();

        return customerRepository.saveAndFlush(newCustomer);
    }

    public Customer findIdException(String id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found"));
    }

    @Override
    public Customer getById(String id) {
        return findIdException(id);
    }

    @Override
    public List<Customer> searchCustomer(SearchCustomerRequest searchCustomerRequest) {
        return customerRepository.searchCustomer(
                searchCustomerRequest.getCustomerName(),
                searchCustomerRequest.getEmail(),
                searchCustomerRequest.getAddress()
        );
    }


    @Override
    public CustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customerById = getById(updateCustomerRequest.getId());

        customerById.setCustomerName(updateCustomerRequest.getCustomerName());
        customerById.setEmail(updateCustomerRequest.getEmail());
        customerById.setAddress(updateCustomerRequest.getAddress());

        customerRepository.saveAndFlush(customerById);

        return CustomerResponse.builder()
                .id(customerById.getId())
                .customerName(customerById.getCustomerName())
                .email(customerById.getEmail())
                .address(customerById.getAddress())
                .build();
    }

    @Override
    public void deleteById(String id) {
        Customer isActive = getById(id);

        customerRepository.delete(isActive);
    }
}

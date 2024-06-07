package com.galgani.Shipping.Company.API.controller;

import com.galgani.Shipping.Company.API.constant.APIUrl;
import com.galgani.Shipping.Company.API.dto.request.NewCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.SearchCustomerRequest;
import com.galgani.Shipping.Company.API.dto.request.UpdateCustomerRequest;
import com.galgani.Shipping.Company.API.dto.response.CommonResponse;
import com.galgani.Shipping.Company.API.dto.response.CustomerResponse;
import com.galgani.Shipping.Company.API.dto.response.PagingResponse;
import com.galgani.Shipping.Company.API.entity.Customer;
import com.galgani.Shipping.Company.API.service.CustomerService;
import com.galgani.Shipping.Company.API.service.Impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.CUSTOMER_API)
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CommonResponse<Customer>> registerCustomer(@RequestBody NewCustomerRequest newCustomerRequest) {
        Customer registerCustomer = customerService.create(newCustomerRequest);

        CommonResponse<Customer> response = CommonResponse.<Customer>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Success Create Customer")
                .data(registerCustomer)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(path = APIUrl.PATH_VAR_ID)
    public ResponseEntity<CommonResponse<Customer>> findCustomerById(@PathVariable String id) {
        Customer customerById = customerService.getById(id);

        CommonResponse<Customer> response = CommonResponse.<Customer>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully Fetch Data")
                .data(customerById)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<Customer>>> findCustomer(
            @RequestParam(name = "customerName", required = false) String customerName,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "address", required = false) String address) {

        SearchCustomerRequest searchCustomerRequest = SearchCustomerRequest.builder()
                .customerName(customerName)
                .email(email)
                .address(address)
                .build();

        List<Customer> allCustomer = customerService.searchCustomer(searchCustomerRequest);

        CommonResponse<List<Customer>> response = CommonResponse.<List<Customer>>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully Fetch Data")
                .data(allCustomer)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<CommonResponse<CustomerResponse>> updateCustomer(@RequestBody UpdateCustomerRequest customer) {
        CustomerResponse updateCustomer = customerService.update(customer);

        CommonResponse<CustomerResponse> response = CommonResponse.<CustomerResponse>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully Update Customer")
                .data(updateCustomer)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CommonResponse<String>> deleteCustomer(@PathVariable String id) {
        customerService.deleteById(id);

        CommonResponse<String> response = CommonResponse.<String>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Customer is Not Active Right Now")
                .build();

        return ResponseEntity.ok(response);
    }
}


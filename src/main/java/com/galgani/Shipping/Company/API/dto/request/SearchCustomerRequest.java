package com.galgani.Shipping.Company.API.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchCustomerRequest {
    private String customerName;
    private String email;
    private String address;

    private Integer page;
    private Integer size;

    private String sortBy;
    private String direction;
}

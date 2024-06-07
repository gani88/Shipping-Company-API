package com.galgani.Shipping.Company.API.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCustomerRequest {
    private String id;

    @NotBlank(message = "Please Fill Your Name")
    private String customerName;

    @NotBlank(message = "Please Fill Your Email")
    private String email;

    @NotBlank(message = "Address Must be Filled")
    private String address;
}

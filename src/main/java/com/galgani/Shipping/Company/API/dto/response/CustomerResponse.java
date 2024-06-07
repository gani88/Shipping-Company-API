package com.galgani.Shipping.Company.API.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CustomerResponse {
    private String id;
    private String customerName;
    private String email;
    private String address;
}

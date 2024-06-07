package com.galgani.Shipping.Company.API.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipmentDetailsResponse {

    private String id;
    private String packageType;
    private Integer weight;
    private String dimensions;
    private String contentDescription;
}

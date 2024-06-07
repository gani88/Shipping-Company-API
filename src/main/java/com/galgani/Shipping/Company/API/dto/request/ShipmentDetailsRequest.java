package com.galgani.Shipping.Company.API.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipmentDetailsRequest {
    private String packageType;
    private Integer weight;
    private String dimensions;
    private String contentDescription;
}

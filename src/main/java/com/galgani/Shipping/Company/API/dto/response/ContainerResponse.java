package com.galgani.Shipping.Company.API.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContainerResponse {
    private String id;
    private String containerType;
    private String location;
    private String shipment_id;
}

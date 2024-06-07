package com.galgani.Shipping.Company.API.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateContainerRequest {
    private String id;

    private String containerType;

    @NotBlank(message = "Location Must be Filled")
    private String location;
}

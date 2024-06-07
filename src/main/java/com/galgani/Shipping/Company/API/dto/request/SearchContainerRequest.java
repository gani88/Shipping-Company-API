package com.galgani.Shipping.Company.API.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchContainerRequest {
    private String containerType;
    private String location;

    private Integer page;
    private Integer size;

    private String sortBy;
    private String direction;
}

package com.galgani.Shipping.Company.API.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse<T> {
    private Integer statusCode;
    private String message;
    private T data;
    private PagingResponse pagingResponse;
}

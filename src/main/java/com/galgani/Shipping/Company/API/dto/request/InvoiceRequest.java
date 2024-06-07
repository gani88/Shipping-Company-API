package com.galgani.Shipping.Company.API.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class InvoiceRequest {
    private Integer amount;
    private Date dueDate;
    private String status;
}

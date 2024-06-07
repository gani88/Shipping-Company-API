package com.galgani.Shipping.Company.API.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class InvoiceResponse {

    private String id;
    private Integer amount;
    private Date dueDate;
    private String status;
}

package com.galgani.Shipping.Company.API.dto.request;

import com.galgani.Shipping.Company.API.dto.response.InvoiceResponse;
import com.galgani.Shipping.Company.API.dto.response.ShipmentDetailsResponse;
import com.galgani.Shipping.Company.API.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ShipmentRequest {

    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
    private String trackingNumber;
    private String customerId;
    private List<ShipmentDetailsRequest> shipmentDetailsRequests;
    private List<InvoiceRequest> invoiceRequests;
}

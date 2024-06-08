package com.galgani.Shipping.Company.API.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchShipmentRequest {
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
    private String trackingNumber;
    private String customerId;
    private List<NewContainerRequest> newContainerRequests;
    private List<ShipmentDetailsRequest> shipmentDetailsRequests;
    private List<InvoiceRequest> invoiceRequests;

    private Integer page;
    private Integer size;

    private String sortBy;
    private String direction;
}

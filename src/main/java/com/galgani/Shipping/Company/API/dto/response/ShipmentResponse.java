package com.galgani.Shipping.Company.API.dto.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.galgani.Shipping.Company.API.entity.Customer;
import com.galgani.Shipping.Company.API.entity.Invoice;
import com.galgani.Shipping.Company.API.entity.ShipmentDetails;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ShipmentResponse {
    private String id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
    private String trackingNumber;
    private String customerId;
    private List<ShipmentDetailsResponse> shipmentDetailsResponses;
    private List<InvoiceResponse> invoiceResponses;
    private List<ContainerResponse> containerResponses;

}

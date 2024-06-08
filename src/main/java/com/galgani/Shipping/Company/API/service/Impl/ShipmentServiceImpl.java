package com.galgani.Shipping.Company.API.service.Impl;

import com.galgani.Shipping.Company.API.dto.request.ShipmentRequest;
import com.galgani.Shipping.Company.API.dto.response.ContainerResponse;
import com.galgani.Shipping.Company.API.dto.response.InvoiceResponse;
import com.galgani.Shipping.Company.API.dto.response.ShipmentDetailsResponse;
import com.galgani.Shipping.Company.API.dto.response.ShipmentResponse;
import com.galgani.Shipping.Company.API.entity.*;
import com.galgani.Shipping.Company.API.repository.ShipmentDetailsRepository;
import com.galgani.Shipping.Company.API.repository.ShipmentRepository;
import com.galgani.Shipping.Company.API.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final ShipmentDetailsService shipmentDetailsService;
    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    private final ContainerService containerService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ShipmentResponse create(ShipmentRequest shipmentRequest) {

        // Save to Shipment
        Customer customerById = customerService.getById(shipmentRequest.getCustomerId());

        Shipment shipment = Shipment.builder()
                .customer(customerById)
                .arrivalDate(shipmentRequest.getArrivalDate())
                .departureDate(shipmentRequest.getDepartureDate())
                .origin(shipmentRequest.getOrigin())
                .destination(shipmentRequest.getDestination())
                .status(shipmentRequest.getStatus())
                .trackingNumber(shipmentRequest.getTrackingNumber())
                .build();

        shipmentRepository.saveAndFlush(shipment);

        // Save to ShipmentDetails
        List<ShipmentDetails> shipmentDetails = shipmentRequest.getShipmentDetailsRequests().stream().map(
            shipmentDetailsRequest -> {
                return ShipmentDetails.builder()
                        .dimensions(shipmentDetailsRequest.getDimensions())
                        .weight(shipmentDetailsRequest.getWeight())
                        .packageType(shipmentDetailsRequest.getPackageType())
                        .contentDescription(shipmentDetailsRequest.getContentDescription())
                        .shipment(shipment)
                        .build();
            }
        ).toList();

        shipmentDetailsService.createBulk(shipmentDetails);

        // Save to Invoice
        List<Invoice> invoices = shipmentRequest.getInvoiceRequests().stream().map(
                invoiceRequest -> {
                    return Invoice.builder()
                            .amount(invoiceRequest.getAmount())
                            .status(invoiceRequest.getStatus())
                            .dueDate(invoiceRequest.getDueDate())
                            .shipment(shipment)
                            .build();
                }
        ).toList();

        invoiceService.createBulk(invoices);

        // Save to Container
        List<Container> containers = shipmentRequest.getNewContainerRequests().stream().map(
                newContainerRequest -> {
                    return Container.builder()
                            .location(newContainerRequest.getLocation())
                            .containerType(newContainerRequest.getContainerType())
                            .shipment(shipment)
                            .build();
                }
        ).toList();

        containerService.createBulk(containers);

        // Response
        List<ShipmentDetailsResponse> shipmentDetailsResponses = shipmentDetails.stream().map(
            shipmentDetails1 -> {
                return ShipmentDetailsResponse.builder()
                        .id(shipmentDetails1.getId())
                        .weight(shipmentDetails1.getWeight())
                        .packageType(shipmentDetails1.getPackageType())
                        .dimensions(shipmentDetails1.getDimensions())
                        .contentDescription(shipmentDetails1.getContentDescription())
                        .build();
            }
        ).toList();

        List<InvoiceResponse> invoiceResponses = invoices.stream().map(
                invoice -> {
                    return InvoiceResponse.builder()
                            .id(invoice.getId())
                            .status(invoice.getStatus())
                            .dueDate(invoice.getDueDate())
                            .amount(invoice.getAmount())
                            .build();

                }
        ).toList();

        List<ContainerResponse> containerResponses = containers.stream().map(
                container -> {
                    return ContainerResponse.builder()
                            .id(container.getId())
                            .location(container.getLocation())
                            .containerType(container.getContainerType())
                            .shipment_id(container.getShipment().getId())
                            .build();
                }
        ).toList();

        return ShipmentResponse.builder()
                .id(shipment.getId())
                .origin(shipment.getOrigin())
                .arrivalDate(shipment.getArrivalDate())
                .departureDate(shipment.getDepartureDate())
                .destination(shipment.getDestination())
                .status(shipment.getStatus())
                .trackingNumber(shipment.getTrackingNumber())
                .customerId(String.valueOf(shipment.getCustomer().getId()))
                .shipmentDetailsResponses(shipmentDetailsResponses)
                .invoiceResponses(invoiceResponses)
                .containerResponses(containerResponses)
                .build();
    }
}

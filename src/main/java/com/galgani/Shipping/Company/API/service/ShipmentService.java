package com.galgani.Shipping.Company.API.service;

import com.galgani.Shipping.Company.API.dto.request.SearchShipmentRequest;
import com.galgani.Shipping.Company.API.dto.request.ShipmentRequest;
import com.galgani.Shipping.Company.API.dto.response.ShipmentResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentService {
    ShipmentResponse create(ShipmentRequest shipmentRequest);
//    List<ShipmentResponse> getAll(SearchShipmentRequest searchShipmentRequest);
}

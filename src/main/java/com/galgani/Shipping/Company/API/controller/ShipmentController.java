package com.galgani.Shipping.Company.API.controller;

import com.galgani.Shipping.Company.API.constant.APIUrl;
import com.galgani.Shipping.Company.API.dto.request.ShipmentRequest;
import com.galgani.Shipping.Company.API.dto.response.CommonResponse;
import com.galgani.Shipping.Company.API.dto.response.ShipmentResponse;
import com.galgani.Shipping.Company.API.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.SHIPMENT_API)
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    public ResponseEntity<CommonResponse<ShipmentResponse>> createNewTransaction(@RequestBody ShipmentRequest shipmentRequest) {
        ShipmentResponse createShipment = shipmentService.create(shipmentRequest);

        CommonResponse<ShipmentResponse> response = CommonResponse.<ShipmentResponse>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Success Create Transaction")
                .data(createShipment)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

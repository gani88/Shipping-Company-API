package com.galgani.Shipping.Company.API.service.Impl;

import com.galgani.Shipping.Company.API.entity.ShipmentDetails;
import com.galgani.Shipping.Company.API.repository.ShipmentDetailsRepository;
import com.galgani.Shipping.Company.API.service.ShipmentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentDetailsServiceImpl implements ShipmentDetailsService {
    private final ShipmentDetailsRepository shipmentDetailsRepository;

    @Override
    public List<ShipmentDetails> createBulk(List<ShipmentDetails> shipmentDetails) {
        return shipmentDetailsRepository.saveAllAndFlush(shipmentDetails);
    }
}

package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.ShipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentDetailsRepository extends JpaRepository<ShipmentDetails, String> {
}
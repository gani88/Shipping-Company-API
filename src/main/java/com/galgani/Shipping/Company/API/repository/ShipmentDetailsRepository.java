package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.ShipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentDetailsRepository extends JpaRepository<ShipmentDetails, String> {
}
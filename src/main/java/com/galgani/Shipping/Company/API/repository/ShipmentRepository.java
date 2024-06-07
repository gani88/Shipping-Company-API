package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
}
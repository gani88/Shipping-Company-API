package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
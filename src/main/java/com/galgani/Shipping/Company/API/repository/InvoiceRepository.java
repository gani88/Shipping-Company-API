package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}
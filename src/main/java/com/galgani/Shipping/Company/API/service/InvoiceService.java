package com.galgani.Shipping.Company.API.service;

import com.galgani.Shipping.Company.API.entity.Invoice;
import com.galgani.Shipping.Company.API.entity.ShipmentDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceService {
    List<Invoice> createBulk(List<Invoice> invoices);
}

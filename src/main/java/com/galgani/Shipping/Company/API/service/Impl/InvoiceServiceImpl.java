package com.galgani.Shipping.Company.API.service.Impl;

import com.galgani.Shipping.Company.API.entity.Invoice;
import com.galgani.Shipping.Company.API.repository.InvoiceRepository;
import com.galgani.Shipping.Company.API.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> createBulk(List<Invoice> invoices) {
        return invoiceRepository.saveAllAndFlush(invoices);
    }
}

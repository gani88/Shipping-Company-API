package com.galgani.Shipping.Company.API.entity;

import com.galgani.Shipping.Company.API.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = ConstantTable.INVOICE)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    private Shipment shipment;
}

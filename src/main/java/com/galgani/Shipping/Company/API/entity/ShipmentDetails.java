package com.galgani.Shipping.Company.API.entity;

import com.galgani.Shipping.Company.API.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = ConstantTable.SHIPMENT_DETAIL)
public class ShipmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "package_type")
    private String packageType;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "content_description")
    private String contentDescription;

    @ManyToOne
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    private Shipment shipment;
}

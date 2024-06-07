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
@Table(name = ConstantTable.CONTAINER)
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "container_type")
    private String containerType;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "shipment_id", referencedColumnName = "id")
    private Shipment shipment;
}

# Shipping Transportation API

This API is designed to manage and track shipping transactions, including the creation, reading, updating, and deleting of data related to shipments, customers, containers, invoices, and shipment details. The API also generates invoices based on shipment transactions.

## Table of Contents
- [Features](#features)
- [Library & Frameworks](#technologies)
- [Entities](#entities)
  - [Container](#container)
  - [Customer](#customer)
  - [Invoice](#invoice)
  - [Shipment](#shipment)
  - [ShipmentDetails](#shipmentdetails)
- [Use Cases](#use-cases)
  - [Native Query Usage](#native-query-usage)
  - [Java Map Usage](#java-map-usage)

## Features
- Create, read, update, and delete (CRUD) operations for shipping-related data.
- Track shipments and generate invoices.
- Search functionality for customers and containers using native queries.
- Custom response creation using Java Maps in the `ShipmentServiceImpl`.

## Library and Frameworks
- Java
- Spring Boot
- JPA/Hibernate
- RESTful API
- JSON

## Entities

### Container
```java
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "container_type")
    private String containerType;

    @Column(name = "location")
    private String location;
}
```

### Customer
```java
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;
}
```

### Invoice
```java
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
    @JoinColumn(name = "shipment_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Shipment shipment;
}
```

### Shipment
```java
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "status")
    private String status;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "shipment")
    @JsonManagedReference
    private List<ShipmentDetails> shipmentDetails;

    @OneToMany(mappedBy = "shipment")
    @JsonManagedReference
    private List<Invoice> invoices;
}
```

### ShipmentDetails
```java
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
    @JoinColumn(name = "shipment_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Shipment shipment;
}
```

## Use Cases

### Native Query Usage
Native queries are used for searching customers and containers. This allows for more complex and optimized queries directly executed in the database.

### Java Map Usage
Java Maps are used in `ShipmentServiceImpl` for creating custom responses. This enables flexible and dynamic response generation based on specific requirements.
## Documentation

[Documentation](https://linktodocumentation)


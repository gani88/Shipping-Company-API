package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(
            value = "SELECT * FROM customers WHERE " +
                    "(:customerName IS NULL OR LOWER(customer_name) LIKE CONCAT('%', LOWER(:customerName), '%')) AND " +
                    "(:email IS NULL OR LOWER(email) LIKE CONCAT('%', LOWER(:email), '%')) AND " +
                    "(:address IS NULL OR LOWER(address) LIKE CONCAT('%', LOWER(:address), '%')) ",
            nativeQuery = true
    )
    List<Customer> searchCustomer(
            @Param("customerName") String customerName,
            @Param("email") String email,
            @Param("address") String address
    );

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customers(id, customer_name, email, address) values(?1, ?2, ?3, ?4) ", nativeQuery = true)
    void insertCustomer(UUID id, String customerName, String email, String address);
}
package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
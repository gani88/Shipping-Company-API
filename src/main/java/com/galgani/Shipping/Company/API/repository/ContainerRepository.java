package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.Container;
import com.galgani.Shipping.Company.API.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<Container, String> {
    @Query(
            value = "SELECT * FROM containers WHERE " +
                    "(:containerType IS NULL OR LOWER(container_type) LIKE CONCAT('%', LOWER(:containerType), '%')) AND " +
                    "(:location IS NULL OR LOWER(location) LIKE CONCAT('%', LOWER(:location), '%'))",
            nativeQuery = true
    )
    List<Container> searchContainer(
            @Param("containerType") String containerType,
            @Param("location") String location
    );

}
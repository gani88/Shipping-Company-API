package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container, String> {
}
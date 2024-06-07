package com.galgani.Shipping.Company.API.repository;

import com.galgani.Shipping.Company.API.entity.TrackingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, String> {
}
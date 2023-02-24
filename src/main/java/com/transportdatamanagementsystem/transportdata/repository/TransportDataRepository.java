package com.transportdatamanagementsystem.transportdata.repository;

import com.transportdatamanagementsystem.transportdata.model.TransportData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportDataRepository extends JpaRepository<TransportData, Long> {
    void deleteTransportDataById(Long id);
}

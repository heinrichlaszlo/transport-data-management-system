package com.transportdatamanagementsystem.transportdata.repository;

import com.transportdatamanagementsystem.transportdata.model.TransportData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportDataRepository extends JpaRepository<TransportData, Long> {
    void deleteTransportDataById(Long id);
}

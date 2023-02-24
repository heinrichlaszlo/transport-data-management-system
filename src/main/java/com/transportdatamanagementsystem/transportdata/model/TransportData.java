package com.transportdatamanagementsystem.transportdata.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TransportData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long Id;

    private String freight;

    private String weight;

    private String fromWhereDeliveryPlace;

    private String whereDeliveryPlace;

    private LocalDate date;
}

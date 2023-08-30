package com.midnight.reservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Subway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column
    private LocalDate today;

    @Column
    private Integer frCode;

    @Column
    private Integer stationCode;

    @Column
    private Integer trainNo;

    @Column
    private LocalTime arrivalTime;

    @Column
    private LocalTime leftTime;

    @Column
    private Integer originStation;

    @Column
    private Integer destStation;

    @Column
    private String subwaySname;

    @Column
    private String subwayEname;

    @Column
    private Integer weekTag;

    @Column
    private Integer inoutTag;
}

package com.midnight.reservation.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class SubwayDto {

    private Integer idx;

    private Integer frCode;

    private Integer stationCode;

    private Integer trainNo;

    private LocalTime arrivalTime;

    private LocalTime leftTime;

    private Integer originStation;

    private Integer destStation;

    private String subwaySname;

    private String subwayEname;

    private Integer weekTag;

    private Integer inoutTag;

    private String stationNm;

    private String remainedTime;
}

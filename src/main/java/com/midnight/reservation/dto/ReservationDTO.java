package com.midnight.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@Setter
public class ReservationDTO {

    private Integer reservationNo;
    private String trainNo;
    private String member;
    private Integer seat;
    private LocalDateTime enrollTime;
    private String departureStn;
    private String arrivalStn;
    private LocalTime reservationTime;
    private LocalTime endTime;

    public ReservationDTO(Integer reservationNo, String trainNo, String member, Integer seat, LocalDateTime enrollTime, String departureStn, String arrivalStn, LocalTime reservationTime, LocalTime endTime) {
        this.reservationNo = reservationNo;
        this.trainNo = trainNo;
        this.member = member;
        this.seat = seat;
        this.enrollTime = enrollTime;
        this.departureStn = departureStn;
        this.arrivalStn = arrivalStn;
        this.reservationTime = reservationTime;
        this.endTime = endTime;
    }

    public ReservationDTO() {}
}

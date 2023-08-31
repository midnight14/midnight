package com.midnight.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


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
    private LocalDateTime reservationTime;
    private LocalDateTime endTime;

    public ReservationDTO(Integer reservationNo, String trainNo, String member, Integer seat, LocalDateTime enrollTime, String departureStn, String arrivalStn, LocalDateTime reservationTime, LocalDateTime endTime) {
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

package com.midnight.reservation.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Entity
@Data
@IdClass(SeatId.class)
public class Seat {
    @Id
    @Column
    private Integer seatNo;

    @Id
    @Column
    private String trainNo;

    @Column
    private Boolean reservationStatus;

    @Id
    @Column
    private LocalDate date;
}

package com.midnight.reservation.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Seat {
    @Id
    @Column
    private Integer seatNo;

    @Column
    private Boolean reservationStatus;

    @Column
    private String trainNo;
}

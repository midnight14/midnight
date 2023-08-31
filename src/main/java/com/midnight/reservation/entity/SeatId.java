package com.midnight.reservation.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

public class SeatId implements Serializable {

    @Column
    private Integer seatNo;

    @Column
    private String trainNo;

    @Column
    private LocalDate date;
}

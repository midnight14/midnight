package com.midnight.reservation.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_idx")
    private Integer reservationNo;

    @Column(name = "train_no")
    private String trainNo;

//    @Column(name = "seat")
//    private String seat;

    @Column(name = "member")
    private String member;

    @Column(name = "enroll_time")
    private LocalDateTime enrollTime;

    @Column(name = "departure_stn")
    private String departureStn;

    @Column(name = "arrival_stn")
    private String arrivalStn;

    @Column(name = "reservation_time")
    private LocalDateTime reservationTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;





}



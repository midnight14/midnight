package com.midnight.reservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class MemberHistory {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column
    private String id;

    @Column
    private LocalDateTime loginTime;

    @Column
    private LocalDateTime logoutTime;
}

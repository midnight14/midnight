package com.midnight.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String pregnancyCycle;
}

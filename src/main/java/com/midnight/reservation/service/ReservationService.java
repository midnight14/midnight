package com.midnight.reservation.service;

import com.midnight.reservation.entity.Reservation;
import com.midnight.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public void updateReservationStatus(Integer reservationNo, Integer id) {

        Reservation reservation = reservationRepository.findByReservationNo(reservationNo);

        reservation.setReservationNo(reservation.getReservationNo());
        reservation.setTrainNo(reservation.getTrainNo());
        reservation.setSeat(reservation.getSeat());
        reservation.setMember(reservation.getMember());
        reservation.setEnrollTime(reservation.getEnrollTime());
        reservation.setDepartureStn(reservation.getDepartureStn());
        reservation.setArrivalStn(reservation.getArrivalStn());
        reservation.setReservationTime(reservation.getReservationTime());
        reservation.setReservationStatus(reservation.getReservationStatus());

        reservationRepository.save(reservation);

    }

//    public Reservation createReservation(Reservation reservation) {
//
//        Reservation reservationEntity = Reservation.builder()
//                .reservationNo(reservation.getReservationNo())
//                .trainNo(reservation.getTrainNo())
//                .seat(reservation.getSeat())
//                .member(reservation.getMember())
//                .enrollTime(reservation.getEnrollTime())
//                .departureStn(reservation.getDepartureStn())
//                .reservationTime(reservation.getReservationTime())
//                .endTime(reservation.getEndTime())
//                .build();
//
//        reservationRepository.save(reservationEntity);
//
//        return reservationEntity;
//
//    }




}

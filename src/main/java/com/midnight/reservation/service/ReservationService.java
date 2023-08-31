package com.midnight.reservation.service;

import com.midnight.reservation.dto.ReservationDTO;
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


    public Reservation registReservation(String id, ReservationDTO reservationDTO) {

        Reservation reservation = new Reservation();

        reservation.setReservationNo(reservation.getReservationNo());
        reservation.setTrainNo(reservation.getTrainNo());
        reservation.setSeat(reservation.getSeat());
        reservation.setMember(reservation.getMember());
        reservation.setEnrollTime(reservation.getEnrollTime());
        reservation.setDepartureStn(reservation.getDepartureStn());
        reservation.setArrivalStn(reservation.getArrivalStn());
        reservation.setReservationTime(reservation.getReservationTime());

        Reservation res = reservationRepository.save(reservation);

        return res;
    }




}

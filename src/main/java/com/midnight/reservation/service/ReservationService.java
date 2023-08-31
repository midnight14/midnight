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

//        Reservation reservation = reservationRepository.findByReservationNo(reservationDTO.getReservationNo());
        Reservation reservation = new Reservation();

        reservation.setTrainNo(reservationDTO.getTrainNo());
//        reservation.setSeat(reservationDTO.getSeat());
        reservation.setSeat(reservationDTO.getSeat());
        reservation.setMember(id);
        reservation.setEnrollTime(LocalDateTime.now());
        reservation.setDepartureStn(reservationDTO.getDepartureStn());
        reservation.setArrivalStn(reservationDTO.getArrivalStn());
        reservation.setReservationTime(reservationDTO.getReservationTime());
        reservation.setEndTime(reservationDTO.getEndTime());

        Reservation res = reservationRepository.save(reservation);

        return res;
    }




}

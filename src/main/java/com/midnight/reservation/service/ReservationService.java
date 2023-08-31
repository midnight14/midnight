package com.midnight.reservation.service;

import com.midnight.reservation.dto.ReservationDTO;
import com.midnight.reservation.entity.Reservation;
import com.midnight.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Transactional
    public Reservation registReservation(String id, ReservationDTO reservationDTO) {

        Reservation reservation = new Reservation();

        reservation.setReservationNo(reservationDTO.getReservationNo());
        reservation.setTrainNo(reservationDTO.getTrainNo());
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

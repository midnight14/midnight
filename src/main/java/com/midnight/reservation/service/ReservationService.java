package com.midnight.reservation.service;

import com.midnight.reservation.dto.ReservationDTO;
import com.midnight.reservation.entity.Reservation;
import com.midnight.reservation.entity.Seat;
import com.midnight.reservation.repository.ReservationRepository;
import com.midnight.reservation.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, SeatRepository seatRepository) {
        this.reservationRepository = reservationRepository;
        this.seatRepository = seatRepository;
    }


    @Transactional
    public Reservation registReservation(String id, ReservationDTO reservationDTO) throws Exception {

        Optional<Seat> foundSeat = seatRepository.findBySeatNoAndReservationStatusAndTrainNoAndDate(reservationDTO.getSeat(),
                true,
                reservationDTO.getTrainNo(),
                LocalDate.now());

        if(foundSeat.isPresent()) {
            throw new Exception("좌석이 예약되어있습니다.");
        } else {

            Seat seat = new Seat();
            seat.setSeatNo(reservationDTO.getSeat());
            seat.setReservationStatus(true);
            seat.setTrainNo(reservationDTO.getTrainNo());
            seat.setDate(LocalDate.now());

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

            seatRepository.save(seat);
            Reservation res = reservationRepository.save(reservation);

            return res;
        }
    }
}

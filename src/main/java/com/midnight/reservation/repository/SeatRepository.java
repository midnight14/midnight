package com.midnight.reservation.repository;

import com.midnight.reservation.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Optional<Seat> findBySeatNoAndReservationStatusAndTrainNoAndDate(Integer seatNo, Boolean seatReservationStatus, String trainNo, LocalDate date);
}

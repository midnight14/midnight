package com.midnight.reservation.repository;

import com.midnight.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Reservation findByReservationNo(Integer reservationNo);






}

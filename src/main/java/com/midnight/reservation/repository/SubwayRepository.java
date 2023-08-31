package com.midnight.reservation.repository;

import com.midnight.reservation.entity.Subway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface SubwayRepository  extends JpaRepository<Subway, Integer> {

    List<Subway> findByWeekTagAndStationNmAndLeftTimeBetween(Integer weekTag, String stationNm, LocalTime time1, LocalTime time2);
}

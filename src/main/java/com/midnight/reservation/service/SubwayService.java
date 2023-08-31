package com.midnight.reservation.service;

import com.midnight.reservation.entity.Subway;
import com.midnight.reservation.repository.SubwayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubwayService {

    private final SubwayRepository subwayRepository;

    public List<Subway> getSubwayList(String station) {

        Integer weekTag = 1;
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.now().plusHours(1);

        List<Subway> subways = subwayRepository.findByWeekTagAndStationNmAndLeftTimeBetween(weekTag, station, time1, time2);

        return subways;
    }
}

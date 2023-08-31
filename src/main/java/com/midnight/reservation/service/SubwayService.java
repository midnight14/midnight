package com.midnight.reservation.service;

import com.midnight.reservation.dto.SubwayDto;
import com.midnight.reservation.entity.Subway;
import com.midnight.reservation.repository.SubwayRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubwayService {

    private final SubwayRepository subwayRepository;
    private final ModelMapper modelMapper;

    public List<SubwayDto> getSubwayList(String station, Pageable pageable) {

        Integer weekTag = 1;
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.now().plusHours(1);

        List<Subway> subways = subwayRepository.findByWeekTagAndStationNmAndLeftTimeBetween(weekTag, station, time1, time2, pageable);

        List<SubwayDto> subwayDtos = new ArrayList<>();

        for(Subway subway : subways) {
            SubwayDto subwayDto =  modelMapper.map(subway, SubwayDto.class);
            Duration duration = Duration.between(LocalTime.now(), subwayDto.getArrivalTime());
            long differenceInMinutes = duration.toMinutes();

            if(differenceInMinutes <= 0) {
                subwayDto.setRemainedTime("곧 도착");
            } else {
                subwayDto.setRemainedTime(String.valueOf(differenceInMinutes) + "분");
            }

            subwayDtos.add(subwayDto);
        }

        return subwayDtos;
    }
}

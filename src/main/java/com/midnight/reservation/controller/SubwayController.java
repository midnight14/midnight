package com.midnight.reservation.controller;

import com.midnight.reservation.dto.SubwayDto;
import com.midnight.reservation.entity.Subway;
import com.midnight.reservation.service.SubwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subway")
@RequiredArgsConstructor
public class SubwayController {

    private final SubwayService subwayService;

    @GetMapping("/list")
    public ResponseEntity getTimeTable(@RequestParam String station,
                                       @PageableDefault(size = 2, sort = "arrivalTime", direction = Sort.Direction.ASC) Pageable pageable) {

        List<SubwayDto> subways = subwayService.getSubwayList(station, pageable);

        return ResponseEntity.ok(subways);
    }
}

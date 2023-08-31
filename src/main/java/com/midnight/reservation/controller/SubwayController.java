package com.midnight.reservation.controller;

import com.midnight.reservation.entity.Subway;
import com.midnight.reservation.service.SubwayService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity getTimeTable(@RequestParam String station) {

        List<Subway> subways = subwayService.getSubwayList(station);

        return ResponseEntity.ok(subways);
    }
}

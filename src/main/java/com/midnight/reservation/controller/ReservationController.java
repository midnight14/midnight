package com.midnight.reservation.controller;


import com.midnight.reservation.dto.ReservationDTO;
import com.midnight.reservation.entity.Reservation;
import com.midnight.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity postReservation(HttpServletRequest request, @RequestBody ReservationDTO reqDto) {

        try {
            String id = (String) request.getSession().getAttribute("id");
            Reservation res = reservationService.registReservation(id, reqDto);

            return ResponseEntity.ok()
                    .body(new JSONObject().appendField("reservation", res));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

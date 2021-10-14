package com.atlen.test.hotel.controllers;

import com.atlen.test.hotel.model.Reservations;
import com.atlen.test.hotel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservations>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAll());
    }
}

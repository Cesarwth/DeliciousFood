package com.atlen.test.hotel.controllers;

import com.atlen.test.hotel.dtos.JsonInputDataDto;
import com.atlen.test.hotel.model.Reservations;
import com.atlen.test.hotel.services.ReservationService;
import com.atlen.test.hotel.services.RoomService;
import com.atlen.test.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Reservations>> getAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping()
    public ResponseEntity<String> saveBook(@RequestBody JsonInputDataDto reservationDto) {
        String response = reservationService.placeReservation(reservationDto);
        if (response.equals("OK"))
            return ResponseEntity.ok("saved successfully");
        else
            return (ResponseEntity<String>) ResponseEntity.badRequest();
    }
}

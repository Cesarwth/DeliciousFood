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

    @PostMapping("/placeReservation")
    public ResponseEntity<String> saveBook(@RequestBody JsonInputDataDto reservationDto) {
        try {
            reservationService.placeReservation(reservationDto);
            return ResponseEntity.ok("The reservation was placed successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /*@PostMapping("/updateReservation")
    public ResponseEntity<String> updateBook(@RequestBody JsonInputDataDto reservationDto){
        try {
            reservationService.updateReservation(reservationDto);
            return ResponseEntity.ok("The reservation was updated successfully");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/cancelReservation")
    public ResponseEntity<String> cancelBook(@RequestBody JsonInputDataDto reservationDto){
        try {
            reservationService.cancelReservation(reservationDto);
            return ResponseEntity.ok("The reservation was canceled successfully");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }*/
}

package com.atlen.test.hotel.controllers;

import com.atlen.test.hotel.model.Rooms;
import com.atlen.test.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public Rooms addRoom(@RequestBody Rooms rooms) {
        return roomService.save(rooms);
    }

    @GetMapping
    public ResponseEntity<List<Rooms>> getAllAvailableRooms() {
        return ResponseEntity.ok(roomService.findAll());
    }
}

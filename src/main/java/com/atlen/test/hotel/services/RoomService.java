package com.atlen.test.hotel.services;

import com.atlen.test.hotel.model.Rooms;
import com.atlen.test.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Rooms save(Rooms rooms) {
        return roomRepository.save(rooms);
    }

    public List<Rooms> findAll() {
        return roomRepository.findAll();
    }
}

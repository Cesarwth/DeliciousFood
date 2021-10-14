package com.atlen.test.hotel.services;

import com.atlen.test.hotel.dtos.RoomDto;
import com.atlen.test.hotel.model.Rooms;
import com.atlen.test.hotel.repository.RoomRepository;
import com.atlen.test.hotel.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    private int id = 1;
    private final String room_description = "Simple";
    private final Double price = Double.valueOf(50);
    private final Integer max_days_reservation = 30;
    private final Integer max_stay_days = 3;
    private final String status = "AVAILABLE";

    @InjectMocks
    private final RoomService roomService = new RoomService();

    @Test
    public void shouldSaveGivenRoom() {
        ArgumentCaptor<Rooms> room = ArgumentCaptor.forClass(Rooms.class);
        RoomDto roomDto = RoomDto.builder().id(id)
                .roomDescription(room_description)
                .price(price)
                .maxDaysReservation(max_days_reservation)
                .maxStayDays(max_stay_days)
                .status(status)
                .build();

        Rooms expectedRoom = new Rooms(1, "Simple", 50.0, 30,3, "AVAILABLE");

        roomService.save(expectedRoom);

        verify(roomRepository).save(room.capture());

        Rooms savedRoom = room.getValue();
        savedRoom.setId(1);

        assertThat(savedRoom).isEqualToComparingFieldByField(expectedRoom);
    }
}

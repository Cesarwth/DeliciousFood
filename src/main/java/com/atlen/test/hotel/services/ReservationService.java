package com.atlen.test.hotel.services;

import com.atlen.test.hotel.dtos.JsonInputDataDto;
import com.atlen.test.hotel.dtos.ReservationDto;
import com.atlen.test.hotel.dtos.UserDto;
import com.atlen.test.hotel.exceptions.LogicBusinessException;
import com.atlen.test.hotel.exceptions.enums.Error;
import com.atlen.test.hotel.mappers.BookMapper;
import com.atlen.test.hotel.model.Reservations;
import com.atlen.test.hotel.model.Rooms;
import com.atlen.test.hotel.model.Users;
import com.atlen.test.hotel.model.enums.ReservationStatus;
import com.atlen.test.hotel.model.enums.RoomStatus;
import com.atlen.test.hotel.repository.ReservationRepository;
import com.atlen.test.hotel.repository.RoomRepository;
import com.atlen.test.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    Integer idRoom;

    public List<Reservations> findAll() {
        return reservationRepository.findAll();
    }

    public String placeReservation(JsonInputDataDto jsonInputDataDto) {
        Rooms rooms = roomRepository.getById(1);
        idRoom = rooms.getId();
        validateDateReservation(jsonInputDataDto);
        validateAvailabilityRoom();
        verifyStayDays(jsonInputDataDto);
        saveBook(jsonInputDataDto);
        return "OK";
    }

    private void saveBook(JsonInputDataDto jsonInputDataDto) {
        saveUser(jsonInputDataDto);
        saveReservation(jsonInputDataDto);
    }

    private void saveUser(JsonInputDataDto jsonInputDataDto){
        UserDto userDto = new UserDto();
        userDto.setPassportNumber(jsonInputDataDto.getPassportNumber());
        userDto.setName(jsonInputDataDto.getName());
        userDto.setPhone(jsonInputDataDto.getPhone());
        userDto.setMail(jsonInputDataDto.getMail());
        userDto.setCountry(jsonInputDataDto.getCountry());
        userRepository.save(BookMapper.dtoToUser(userDto));
    }

    private void saveReservation(JsonInputDataDto jsonInputDataDto){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setReservation_description(jsonInputDataDto.getReservationDescription());
        reservationDto.setDate_reservation(jsonInputDataDto.getDateReservation());
        reservationDto.setDate_check_in(jsonInputDataDto.getDateCheckIn());
        reservationDto.setDate_check_out(jsonInputDataDto.getDateCheckOut());
        reservationDto.setStatus(String.valueOf(ReservationStatus.CREATED));
        reservationDto.setId_room(idRoom);
        reservationDto.setPassport_number(jsonInputDataDto.getPassportNumber());
        reservationRepository.save(BookMapper.dtoToReservation(reservationDto));
    }

    private void verifyStayDays(JsonInputDataDto reservationDto) {
        Rooms roms = roomRepository.getById(idRoom);
        Date dateCheckIn = reservationDto.getDateCheckIn();
        Date dateCheckOut = reservationDto.getDateCheckOut();
        Long differenceDays = differenceDays(dateCheckOut, dateCheckIn);
        if (differenceDays > roms.getMax_stay_days()){
            throw new LogicBusinessException(Error.STAY_DAYS_EXCEPTION);
        }
    }

    private Long differenceDays(Date secondDate, Date firstDate){
        long differenceInMilliSeconds = Math.abs(secondDate.getTime() - firstDate.getTime());
        long differenceDays = TimeUnit.DAYS.convert(differenceInMilliSeconds, TimeUnit.MILLISECONDS);
        return differenceDays;
    }

    private void validateDateReservation(JsonInputDataDto reservationDto) {
        Date dateReservation = reservationDto.getDateReservation();
        Date dateCheckIn = reservationDto.getDateCheckIn();
        Rooms rooms = roomRepository.getById(idRoom);
        Long differenceDays = differenceDays(dateReservation, dateCheckIn);
        if (dateCheckIn.equals(dateReservation)) {
            throw new LogicBusinessException(Error.VALIDATE_DATE_EXCEPCION);
        }
        else if (differenceDays > rooms.getMax_days_reservation()){
            throw new LogicBusinessException(Error.VALIDATE_LIMIT_DATE_EXCEPCION);
        }
    }

    private void validateAvailabilityRoom() {
        Rooms roms = roomRepository.getById(idRoom);
        if (roms.getStatus().equals(RoomStatus.UNAVAILABLE)){
            throw new LogicBusinessException(Error.VALIDATE_AVAILABILITY_ROOM_EXCEPTION);
        }
    }

}

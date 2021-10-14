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

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    Integer idRoom;

    public void getIdRoom() {
        Rooms rooms = roomRepository.getById(1);
        idRoom = rooms.getId();
    }

    public Integer userAlreadyExist(String passportNumber) {
        return userRepository.findUserByPassportNumber(passportNumber);
    }

    public void saveBook(JsonInputDataDto jsonInputDataDto) {
        saveUser(jsonInputDataDto);
        saveReservation(jsonInputDataDto);
    }

    public void saveUser(JsonInputDataDto jsonInputDataDto) {
        Integer id_user = userAlreadyExist(jsonInputDataDto.getPassportNumber());
        UserDto userDto = new UserDto();
        userDto.setPassportNumber(jsonInputDataDto.getPassportNumber());
        userDto.setName(jsonInputDataDto.getName());
        userDto.setPhone(jsonInputDataDto.getPhone());
        userDto.setMail(jsonInputDataDto.getMail());
        userDto.setCountry(jsonInputDataDto.getCountry());
        if (id_user != null) {
            Users actualUser = BookMapper.dtoToUser(userDto);
            actualUser.setId(id_user);
            userRepository.save(actualUser);
        } else {
            userRepository.save(BookMapper.dtoToUser(userDto));
        }
    }

    public void saveReservation(JsonInputDataDto jsonInputDataDto) {
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

    public void verifyStayDays(JsonInputDataDto reservationDto) {
        Rooms roms = roomRepository.getById(idRoom);
        Date dateCheckIn = reservationDto.getDateCheckIn();
        Date dateCheckOut = reservationDto.getDateCheckOut();
        Long differenceDays = differenceDays(dateCheckOut, dateCheckIn);
        if (differenceDays > roms.getMax_stay_days()) {
            throw new LogicBusinessException(Error.STAY_DAYS_EXCEPTION);
        }
    }

    private Long differenceDays(Date secondDate, Date firstDate) {
        long differenceInMilliSeconds = Math.abs(secondDate.getTime() - firstDate.getTime());
        return TimeUnit.DAYS.convert(differenceInMilliSeconds, TimeUnit.MILLISECONDS);
    }

    public void validateDateReservation(JsonInputDataDto reservationDto) {
        Date dateReservation = reservationDto.getDateReservation();
        Date dateCheckIn = reservationDto.getDateCheckIn();
        if (dateCheckIn.equals(dateReservation)) {
            throw new LogicBusinessException(Error.VALIDATE_DATE_EXCEPCION);
        }
    }

    public void validateMaxDateReservation(JsonInputDataDto reservationDto) {
        Rooms rooms = roomRepository.getById(idRoom);
        Date dateReservation = reservationDto.getDateReservation();
        Date dateCheckIn = reservationDto.getDateCheckIn();
        Long differenceDays = differenceDays(dateReservation, dateCheckIn);
        if (differenceDays > rooms.getMax_days_reservation()) {
            throw new LogicBusinessException(Error.VALIDATE_LIMIT_DATE_EXCEPCION);
        }
    }

    public void validateAvailabilityRoom() {
        Rooms roms = roomRepository.getById(idRoom);
        if (roms.getStatus() == String.valueOf(RoomStatus.UNAVAILABLE)) {
            throw new LogicBusinessException(Error.VALIDATE_AVAILABILITY_ROOM_EXCEPTION);
        }
    }

    public void validateAvailabilityDates(JsonInputDataDto jsonInputDataDto) {
        List<Reservations> reservationList = reservationRepository.findAll();
        for (Reservations reservations : reservationList){
            Date dateIn = reservations.getDate_check_in();
            Date dateInJson = jsonInputDataDto.getDateCheckIn();
            Date dateOut = reservations.getDate_check_out();
            Date dateOutJson = jsonInputDataDto.getDateCheckOut();
            if(dateInJson.equals(dateIn) || dateInJson.equals(dateOut)){
                throw new LogicBusinessException(Error.DATE_CHECK_AVAILABILITY_EXCEPTION);
            }
            if(dateInJson.compareTo(dateIn) > 0 && dateInJson.compareTo(dateOut) < 0){
                throw new LogicBusinessException(Error.DATE_CHECK_AVAILABILITY_EXCEPTION);
            }
            if(dateOutJson.equals(dateIn) || dateOutJson.equals(dateOut)){
                throw new LogicBusinessException(Error.DATE_CHECK_AVAILABILITY_EXCEPTION);
            }
            if(dateOutJson.compareTo(dateIn) > 0 && dateOutJson.compareTo(dateOut) < 0){
                throw new LogicBusinessException(Error.DATE_CHECK_AVAILABILITY_EXCEPTION);
            }
        }
    }
}

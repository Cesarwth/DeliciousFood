package com.atlen.test.hotel.mappers;

import com.atlen.test.hotel.dtos.ReservationDto;
import com.atlen.test.hotel.dtos.UserDto;
import com.atlen.test.hotel.model.Reservations;
import com.atlen.test.hotel.model.Users;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public static Users dtoToUser(UserDto userDto){
        return Users.builder().passport_number(userDto.getPassportNumber())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .mail(userDto.getMail())
                .country(userDto.getCountry()).build();
    }

    public static Reservations dtoToReservation(ReservationDto reservationDto){
        return Reservations.builder().reservation_description(reservationDto.getReservation_description())
                .date_reservation(reservationDto.getDate_reservation())
                .date_check_in(reservationDto.getDate_check_in())
                .date_check_out(reservationDto.getDate_check_out())
                .status(reservationDto.getStatus())
                .passport_number(reservationDto.getPassport_number())
                .id_room(reservationDto.getId_room()).build();
    }
}

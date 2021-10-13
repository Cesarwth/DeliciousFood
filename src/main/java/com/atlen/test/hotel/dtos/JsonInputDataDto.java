package com.atlen.test.hotel.dtos;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonInputDataDto {

    private String reservationDescription;
    private Date dateReservation;
    private Date dateCheckIn;
    private Date dateCheckOut;

    private String passportNumber;
    private String name;
    private String phone;
    private String mail;
    private String country;


}

package com.atlen.test.hotel.dtos;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ReservationDto {
    private Integer id;
    private String reservation_description;
    private Date date_reservation;
    private Date date_check_in;
    private Date date_check_out;
    private String status;
    private String passport_number;
    private Integer id_room;
}

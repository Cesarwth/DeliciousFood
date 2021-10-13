package com.atlen.test.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="reservations")
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String reservation_description;
    private Date date_reservation;
    private Date date_check_in;
    private Date date_check_out;
    private String status;
    private String passport_number;
    private Integer id_room;
}

package com.atlen.test.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String room_description;
    private Double price;
    private Integer max_days_reservation;
    private Integer max_stay_days;
    private String status;

}

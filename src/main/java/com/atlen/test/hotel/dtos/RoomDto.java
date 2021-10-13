package com.atlen.test.hotel.dtos;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RoomDto {
    private int id;
    private String roomDescription;
    private Double price;
    private Integer maxStayDays;
    private Integer maxDaysReservation;
}

package com.atlen.test.hotel.dtos;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "passport_number")
public class UserDto {
    private String passportNumber;
    private String name;
    private String phone;
    private String mail;
    private String country;
}

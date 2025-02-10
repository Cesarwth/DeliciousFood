package com.deliciousfood.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

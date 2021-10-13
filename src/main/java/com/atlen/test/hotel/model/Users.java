package com.atlen.test.hotel.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "passport_number", unique = true, nullable = false)
    private String passport_number;
    private String name;
    private String phone;
    private String mail;
    private String country;
}

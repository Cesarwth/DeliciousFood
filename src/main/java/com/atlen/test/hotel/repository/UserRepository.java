package com.atlen.test.hotel.repository;

import com.atlen.test.hotel.dtos.UserDto;
import com.atlen.test.hotel.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT u.id " +
            " FROM users u WHERE u.passport_number=:passport_number", nativeQuery = true)
    Integer findUserByPassportNumber(@Param("passport_number") String passport_number);
}

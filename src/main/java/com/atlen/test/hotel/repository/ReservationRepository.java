package com.atlen.test.hotel.repository;

import com.atlen.test.hotel.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer> {

    @Query(value = "SELECT r.id FROM reservations r WHERE r.passport_number=:passport_number AND r.status NOT IN (:status) LIMIT 1", nativeQuery = true)
    Integer findReservationByPassportNumber(@Param("passport_number") String passport_number, @Param("status") String status);

    @Modifying
    @Query(value = "UPDATE reservations set status = :status WHERE passport_number=:passport_number AND status NOT IN (:status)", nativeQuery = true)
    void cancelReservation(@Param("passport_number") String passport_number, @Param("status") String status);

    @Query(value = "SELECT * FROM reservations r WHERE r.passport_number NOT IN (:passport_number)", nativeQuery = true)
    List<Reservations> findAllExceptTheSame(@Param("passport_number") String passportNumber);
}

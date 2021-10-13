package com.atlen.test.hotel.repository;

import com.atlen.test.hotel.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer> {
}

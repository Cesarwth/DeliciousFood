package com.atlen.test.hotel.repository;

import com.atlen.test.hotel.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Rooms, Integer> {

    @Query(value = "SELECT r.id FROM rooms r WHERE r.status =:status LIMIT 1", nativeQuery = true)
    Integer findAvailableRoom(@Param("status") String status);
}

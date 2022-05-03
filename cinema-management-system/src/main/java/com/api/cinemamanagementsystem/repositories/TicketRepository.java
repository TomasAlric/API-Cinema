package com.api.cinemamanagementsystem.repositories;

import com.api.cinemamanagementsystem.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select count(t) from Ticket t where t.session.room.id = :roomId")
    Integer coundSoldTicketsBySessionAndRom(@Param("roomId") Long roomId);
}

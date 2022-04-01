package com.api.cinemamanagementsystem.repositories;

import com.api.cinemamanagementsystem.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Long> {
}

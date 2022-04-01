package com.api.cinemamanagementsystem.dtos;


import com.api.cinemamanagementsystem.models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private double valueOfTicket;

    private double discount;

    private Integer seat;

    private Long usersId;

    Set<SessionDTO> sessions = new HashSet<>();

    public TicketDTO(Ticket entity){
        id = entity.getId();
        valueOfTicket = entity.getValueOfTicket();
        discount = entity.getDiscount();
        seat = entity.getSeat();
        usersId = entity.getUsers().getId();
      //  entity.getSessions().forEach(session -> this.sessions.add(new SessionDTO(session)));
    }
}

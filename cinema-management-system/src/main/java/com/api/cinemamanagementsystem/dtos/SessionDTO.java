package com.api.cinemamanagementsystem.dtos;

import com.api.cinemamanagementsystem.models.Room;
import com.api.cinemamanagementsystem.models.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String movie;

    private String synopsis;

    private String room;

    private RoomDTO roomDTO;

    private LocalDateTime dateSession;

    private Long ticketId;

    Set<RoomDTO> rooms = new HashSet<RoomDTO>();

    public SessionDTO(Session entity){
        id = entity.getId();
        movie = entity.getMovie();
        synopsis = entity.getSynopsis();
        room = entity.getRoom().getRoomName();
        dateSession = entity.getDateSession();
        ticketId = 2L;
                //entity.getTickets().getId();
    }

//    public SessionDTO(Session entity, Set<Room> rooms){
//        this(entity);
//
//        rooms.forEach(room -> this.rooms.add(new RoomDTO(room)));
//    }
}

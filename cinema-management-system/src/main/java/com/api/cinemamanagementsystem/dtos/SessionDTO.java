package com.api.cinemamanagementsystem.dtos;

import com.api.cinemamanagementsystem.models.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String movie;

    private String synopsis;

    @Autowired
    private RoomDTO roomDTO;

    private LocalDateTime dateSession;

    private Long ticketsId;

    public SessionDTO(Session entity) {
        id = entity.getId();
        movie = entity.getMovie();
        synopsis = entity.getSynopsis();
        dateSession = entity.getDateSession();

    }
}
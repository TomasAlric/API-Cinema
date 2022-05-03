package com.api.cinemamanagementsystem.dtos;

import com.api.cinemamanagementsystem.models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String roomName;

    private Integer seats;

    private Long sessionsId;

    public RoomDTO(Room entity){
        id = entity.getId();
        roomName = entity.getRoomName();
        seats = entity.getSeats();
        sessionsId =1L;
                //entity.getSessions().getId();
    }

}

package com.api.cinemamanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "room")
public class Room  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private Integer seats;

    @OneToMany(mappedBy = "room")
    private List<Session> sessions;

}
/**
APPROACH 1
    ROOM
        |id| title|
        | 1| sala do tomas |


SESSION
     |room_id| date| session_id
     | 1 | 2019-02-12 | 1
     | 1 | 2018-02-12 | 2


 APPROACH 2 (N X N)
     ROOM
     |id| title|
     | 1| sala do tomas |

     SESSION
      | date| session_id
      | 2019-02-12 | 1
      | 2018-02-12 | 2

     ROOM_SESSION (N x N)
        | session_id | room_id | 3 | date

*/
